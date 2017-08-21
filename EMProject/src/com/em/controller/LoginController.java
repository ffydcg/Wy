package com.em.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.em.model.Owner;
import com.em.model.UserInfo;
import com.em.service.OwnerService;
import com.em.service.UserService;
import com.github.pagehelper.PageInfo;

@Controller
public class LoginController extends BaseController{
	//登录
	@Resource
	private UserService userService;
	@Resource
	private OwnerService ownerService;
	@RequestMapping("/login.do")
	public String login(UserInfo userInfo,final ModelMap model,HttpServletRequest request)throws Exception{
		//调用service进行用户身份验证
		try{
		System.out.println("____________");
		UserInfo ui=userService.login(userInfo);
		if(ui==null){
			model.put("errMsg", "用户名或密码错误");
			return "index";
		}else{
		   PageInfo<Owner> page=ownerService.queryOwnerPage(null, 1, 6);
		    HttpSession session=request.getSession();
		    session.setAttribute("userInfo", userInfo);
			model.put("userInfo", userInfo);
			model.put("page", page);
			return "/owner/mange";
		}
		}catch(Exception e){
			e.printStackTrace();
			model.put("errMsg", "系统错误");
			return "index";
		}
	}
  @RequestMapping("/toResetPwd.do")
  public String toResetPwd(){
	  return "changePwd";
  }
	
  @RequestMapping("/resetPwd.do")
  public void resetPwd(@RequestParam Map<String,String> params,HttpServletResponse response) throws Exception{
	  String userName=params.get("userName");
	  String password=params.get("password");
	  UserInfo ui=new UserInfo();
	  ui.setUserName(userName);
	  ui.setPassword(password);
	  UserInfo nui=userService.login(ui);
	  if(nui==null){
		  outText(response, "0001");
      }
	  String passwordN=params.get("passwdN");
	  nui.setPassword(passwordN);
     int num=userService.resetPwd(nui);
     if(num==1){
    	 outText(response, "0000");
     }else{
    	 outText(response, "0001");
     }
}
  @RequestMapping("logout.do")
  public String logout(HttpSession httpSession){
	  httpSession.removeAttribute("userInfo");
	  httpSession.invalidate();
	  return "index";
  }
}