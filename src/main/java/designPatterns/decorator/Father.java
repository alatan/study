package designPatterns.decorator;

/**
 * 装饰器模式（动态地给一个对象添加一些额外的职责。）
 *
 * 使用场景
 *  ● 需要扩展一个类的功能，或给一个类增加附加功能。
 *  ● 需要动态地给一个对象增加功能，这些功能可以再动态地撤销。
 *  ● 需要为一批的兄弟类进行改装或加装功能，当然是首选装饰模式。
 *
 * 通过模拟装饰不好的考试成绩场景😄
 */
public class Father {
    public static void main(String[] args) {
        //把成绩单拿过来
        SchoolReport sr;
        //原装的成绩单
        sr = new FouthGradeSchoolReport();
        //加了最高分说明的成绩单（第一次装饰）
        sr = new HighScoreDecorator(sr);
        //又加了成绩排名的说明（第二次装饰）
        sr = new SortDecorator(sr);
        //看成绩单
        sr.report();
        //然后老爸一看，很开心，就签名了
        sr.sign("老三");  //我叫小三，老爸当然叫老三
    }
}
