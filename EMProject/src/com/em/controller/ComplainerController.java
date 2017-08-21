package com.em.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.em.model.Complainer;
import com.em.service.ComplainerService;
import com.github.pagehelper.PageInfo;
@Controller
public class ComplainerController extends BaseController{
	@Resource
	private ComplainerService complainerService;
	
	@RequestMapping("/toCAdd.do")
	public String toCompainerAdd() {
		return "/complainer/ComplainerAdd";
	}

	@RequestMapping("/cAdd.do")
	public void complainerAdd(HttpServletResponse response,@RequestParam Map<String,String> params)
			throws Exception {
		//
		Complainer compainer=new Complainer();
		String comOwnerName=params.get("comOwnerName");
		String comAccepter=params.get("comAccepter");
		String comOwnerNo=params.get("comOwnerNo");
		Date comDate=new SimpleDateFormat("yyyy-MM-dd").parse(params.get("comDate"));
		Date handleDate=new SimpleDateFormat("yyyy-MM-dd").parse(params.get("handleDate"));
		String comContent=params.get("comContent");
		compainer.setComAccepter(comAccepter);
		compainer.setComContent(comContent);
		compainer.setComDate(comDate);
		compainer.setComOwnerName(comOwnerName);
        compainer.setComOwnerNo(comOwnerNo);
        compainer.setHandleDate(handleDate);
       int num= complainerService.complainerrAdd(compainer);
       if(num==1){
    	   outText(response, "0000");
       }else{
    	   outText(response, "0001");
       }
        
	}
    @RequestMapping("listComplainerByNum.do")
    public String listComplainerByNum(final ModelMap model,int num){
    	PageInfo<Complainer> page = complainerService.queryComplainerPage(null, num, 6);
		model.put("page", page);
		return "/complainer/mange";
    }
    
	@RequestMapping("/listComplainer.do")
	public String listComplainer(final ModelMap model) {
		PageInfo<Complainer> page = complainerService.queryComplainerPage(null, 1, 6);
		model.put("page", page);
		return "/complainer/mange";
	}

	@RequestMapping("/toComplainerMdf.do")
	public String toComplainerMdf(int id, final ModelMap model) {
		Complainer o = complainerService.queryComplainerById(id);
		model.put("complainer", o);
		model.put("m", "1");
		return "/complainer/ComplainerAdd";
	}

	@RequestMapping("/cMode.do")
	public void updateComplainer( HttpServletResponse response,@RequestParam Map<String,String> params)
			throws Exception {
		
		Complainer compainer=new Complainer();
		String comOwnerName=params.get("comOwnerName");
		String comAccepter=params.get("comAccepter");
		String comOwnerNo=params.get("comOwnerNo");
		Date comDate=new SimpleDateFormat("yyyy-MM-dd").parse(params.get("comDate"));
		Date handleDate=new SimpleDateFormat("yyyy-MM-dd").parse(params.get("handleDate"));
		String comContent=params.get("comContent");
		compainer.setComAccepter(comAccepter);
		compainer.setComContent(comContent);
		compainer.setComDate(comDate);
		compainer.setComOwnerName(comOwnerName);
        compainer.setComOwnerNo(comOwnerNo);
        compainer.setHandleDate(handleDate);
        compainer.setId(Integer.parseInt(params.get("id")));
		int num = complainerService.updateComplainer(compainer);
		if (num == 1) {
			 outText(response, "0000");
		} else {
			 outText(response, "0001");
		}
	}
	@RequestMapping("/delC.do")
	public void deleteComplainer(int id,HttpServletResponse response) throws Exception{
		int num = complainerService.deleteComplainer(id);
		if (num == 1) {
			 outText(response, "0000");
		} else {
			 outText(response, "0001");
		}
	}
	@RequestMapping("/queryComplainerByName.do")
	public String queryOwnerByName(String name,final ModelMap model) throws Exception{
		System.out.println("name:"+name);
		//String nameT=new String(name.getBytes("ISO-8869-1"),"UTF-8"); 
		PageInfo<Complainer> page = complainerService.querComplainerByName("%"+name+"%", 1, 6);
		model.put("page", page);
		return "/complainer/mange";
	}
	

}
