package designPatterns.factory;

public abstract class AbstractHumanFactory<T> {
    public abstract  T createHuman(Class c);
}
