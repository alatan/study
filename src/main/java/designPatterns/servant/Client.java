package designPatterns.servant;

/**
 * 雇工模式
 * 雇工模式是行为模式的一种，它为一组类提供通用的功能，而不需要类实现这些功能，它是命令模式的一种扩展
 */
public class Client {
    public static void main(String[] args) {
        //厨师清洁厨房
        Cleaner cookie = new Cleaner();
        cookie.clean(new Kitchen());
        //园丁清洁花园
        Cleaner gardener = new Cleaner();
        gardener.clean(new Garden());
        //裁缝清洁衣服
        Cleaner tailer = new Cleaner();
        tailer.clean(new Cloth());
    }
}
