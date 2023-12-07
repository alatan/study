package javaBase.annotation;

public class User {
    //使用我们的自定义注解
    @MyField(description = "用户名", length = 12)
    private String username;
}
