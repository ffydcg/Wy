package com.em.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class BaseController {
public void outText(HttpServletResponse response,String text){
	try {
		response.getWriter().append(text);
		response.getWriter().flush();
		response.getWriter().close();
		return ;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
