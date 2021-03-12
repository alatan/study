package useage;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 高并发高性能缓存器
 * @param <A> 参数
 * @param <V> 结果
 */
public class ConcurrentCache<A, V>  implements Computable<A, V>  {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V>   c;

    public ConcurrentCache(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException, ExecutionException {
        Future<V> f = cache.get(arg);
        if(f == null){
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.putIfAbsent(arg, ft);
            ft.run(); //调用c.compute
        }
        try {
            return f.get();
        }catch (ExecutionException e){
            throw e;
        }
    }
}
