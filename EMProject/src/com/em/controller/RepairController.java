package com.em.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.em.model.Repair;
import com.em.service.RepairService;
import com.github.pagehelper.PageInfo;

@Controller
public class RepairController extends BaseController{
@Resource
private RepairService repairService;
@RequestMapping("/toRAdd.do")
public String toRepairAdd() {
	return "/repair/RepairAdd";
}

@RequestMapping("/rAdd.do")
public void repairAdd(Repair repair, HttpServletResponse response)
		throws Exception {
	int num = repairService.repairAdd(repair);
	if (num == 1) {
		 outText(response, "0000");
	} else {
		 outText(response, "0001");
	}
}
@RequestMapping("listRepairByNum.do")
public String listRepairByNum(final ModelMap model,int num){
	PageInfo<Repair> page = repairService.queryRepairPage(null, num, 6);
	model.put("page", page);
	return "/repair/mange";
}

@RequestMapping("/listRepair.do")
public String listRepair(final ModelMap model) {
	PageInfo<Repair> page = repairService.queryRepairPage(null, 1, 6);
	model.put("page", page);
	return "/repair/mange";
}

@RequestMapping("/toRepairMdf.do")
public String toRepairMdf(int id, final ModelMap model) {
	
	Repair o = repairService.queryRepairById(id);
	
	model.put("repair", o);
	
	model.put("m", "1");
	System.out.println(model);
	return "/repair/RepairAdd";
}

@RequestMapping("/rMode.do")
public void repairM(Repair owner, HttpServletResponse response)
		throws Exception {
	int num = repairService.updateRepair(owner);
	if (num == 1) {
		 outText(response, "0000");
	} else {
		 outText(response, "0001");
	}
}
@RequestMapping("/delR.do")
public void delRepair(int id,HttpServletResponse response) throws Exception{
	int num = repairService.deleteRepair(id);
	if (num == 1) {
		 outText(response, "0000");
	} else {
		 outText(response, "0001");
	}
}
@RequestMapping("/queryRepairByName.do")
public String queryepairByName(String name,final ModelMap model) throws Exception{
	System.out.println("name:"+name);
	//String nameT=new String(name.getBytes("ISO-8859-1"),"UTF-8"); 
	PageInfo<Repair> page = repairService.querRepairByName("%"+name+"%", 1, 6);
	model.put("page", page);
	return "/repair/mange";
}
}
