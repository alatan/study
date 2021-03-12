package designPatterns.factory;

public class HumanFactory<T> extends AbstractHumanFactory<T> {
    public  T createHuman(Class c){
        //定义一个生产的人种
        T human=null;
        try {
            //产生一个人种
            human = (T)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("人种生成错误！");
        }
        return human;
    }
}