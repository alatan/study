package designPatterns.spec;

/**
 * 非规格书
 */
public class NotSpecification extends CompositeSpecification {
    //传递一个规格书
    private IUserSpecification spec;
    public NotSpecification(IUserSpecification _spec){
        this.spec = _spec;
    }
    //not操作
    @Override
    public boolean isSatisfiedBy(User user) {
        return !spec.isSatisfiedBy(user);
    }
}
