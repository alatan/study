package designPatterns.prototype;

import java.util.Random;

/**
 * 原型模式（不通过new关键字来产生一个对象，而是通过clone对象复制来实现的模式就叫做原型模式。）
 *
 * 应用场景
 * ● 性能和安全要求的场景（原型模式是在内存二进制流的拷贝，要比直接new一个对象性能好很多，特别是要在一个循环体内产生大量的对象时，原型模式可以更好地体现其优点。）
 * ● 一个对象多个修改者的场景 （一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。）
 */
public class Client {
    //发送账单的数量，这个值是从数据库中获得
    private static int MAX_COUNT = 6;
    public static void main(String[] args) {
        //模拟发送邮件
        int i=0;
        //把模板定义出来，这个是从数据中获得
        Mail mail = new Mail(new AdvTemplate());
        mail.setTail("招商银行版权所有");
        while(i<MAX_COUNT){
            //以下是每封邮件不同的地方
            /**
             * //这种不通过new关键字来产生一个对象，而是通过clone对象复制来实现的模式就叫做原型模式。
             */
            Mail cloneMail = mail.clone();
            cloneMail.setAppellation(getRandString(5)+" 先生（女士）");
            cloneMail.setReceiver(getRandString(5)+"@"+getRandString(8)+".com");
            //然后发送邮件
            sendMail(cloneMail);
            i++;
        }
    }
    //发送邮件
    public static void sendMail(Mail mail){
        System.out.println("标题："+mail.getSubject() + "\t收件人："+mail.getReceiver()+"\t...发送成功！");
    }

    //获得指定长度的随机字符串
    public static String getRandString(int maxLength){
        String source ="abcdefghijklmnopqrskuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random rand = new Random();
        for(int i=0;i<maxLength;i++){
            sb.append(source.charAt(rand.nextInt(source.length())));
        }
        return sb.toString();
    }
}
