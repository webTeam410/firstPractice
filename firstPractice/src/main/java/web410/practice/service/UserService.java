package web410.practice.service;

import web410.practice.model.User;

public interface UserService {
    
//    public List<User> findStuUserByTj(int academyid,int majorid,int classid);
	public User checkUser(String loginName, String passWord);
}
