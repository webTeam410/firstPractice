package web410.practice.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web410.practice.dao.UserMapper;
import web410.practice.model.User;
import web410.practice.service.UserService;



@Service("userService")
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@SuppressWarnings("finally")
	public User checkUser(String loginName, String passWord) {
		User result = null;
		try {
			User record = new User();
			record.setUserLoginname(loginName);
			record.setUserPassword(passWord);
			
			result = userMapper.checkUser(record);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			return result;
		}
	}
}
