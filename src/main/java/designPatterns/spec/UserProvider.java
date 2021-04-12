package designPatterns.spec;

import java.util.ArrayList;

public class UserProvider implements IUserProvider {
    //用户列表
    private ArrayList<User> userList;
    //传递用户列表
    public UserProvider(ArrayList _userList){
        this.userList = _userList;
    }
    //根据指定的规格书查找用户
    public ArrayList findUser(IUserSpecification userSpec) {
        ArrayList<User> result = new ArrayList();
        for(User u:userList){
            if(userSpec.isSatisfiedBy(u)){//符合指定规格
                result.add(u);
            }
        }
        return result;
    }
}