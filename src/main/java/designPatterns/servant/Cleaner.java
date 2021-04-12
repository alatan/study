package designPatterns.servant;

/**
 * 雇工类-清洁者
 */
public class Cleaner {
    //清洁
    public void clean(Cleanable clean){
        clean.celaned();
    }
}
