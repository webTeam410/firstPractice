package web410.practice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



//import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import web410.practice.model.User;
import web410.practice.service.UserService;


@Controller
@RequestMapping("/userController")
public class UserController {

	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/* author:yangjunhui func:确定查询条件 */
	@SuppressWarnings({ "rawtypes", "unchecked", "finally" })
	@RequestMapping("/checkUser")
	public ModelAndView CheckUser(String loginName, String passWord,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MappingJacksonJsonView view = new MappingJacksonJsonView();
		Map map = new HashMap();
		User user = null;
		try {
			user = userService.checkUser(loginName, passWord);
			if(user != null){
				map.put("result", Boolean.TRUE);
				map.put("message", "success");
			}else{
				map.put("result", Boolean.FALSE);
				map.put("message", "用户名或密码错误！");
			}
		} catch (Exception e) {
			map.put("result", Boolean.FALSE);
			map.put("message", "执行出现出错！");
			e.printStackTrace();
		} finally {
			view.setAttributesMap(map);
			mav.setView(view);
			return mav;
		}
	}

}
