package com.em.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.em.model.Owner;
import com.em.service.OwnerService;
import com.github.pagehelper.PageInfo;

@Controller
public class OwnerController extends BaseController{
	@Resource
	private OwnerService ownerService;

	@RequestMapping("/toOAdd.do")
	public String toOwnerAdd() {
		return "/owner/OwnerAdd";
	}

	@RequestMapping("/oAdd.do")
	public void ownerAdd(Owner owner, HttpServletResponse response)
			throws Exception {
        owner.setOwnerCheckinDate(new Date());
		int num = ownerService.ownerAdd(owner);
		if (num == 1) {
			 outText(response, "0000");
		} else {
			 outText(response, "0001");
		}
	}
    @RequestMapping("listOwnerByNum.do")
    public String listOwnerByNum(final ModelMap model,int num){
    	PageInfo<Owner> page = ownerService.queryOwnerPage(null, num, 6);
		model.put("page", page);
		return "/owner/mange";
    }
    
	@RequestMapping("/listOwner.do")
	public String listOwner(final ModelMap model) {
		PageInfo<Owner> page = ownerService.queryOwnerPage(null, 1, 6);
		model.put("page", page);
		return "/owner/mange";
	}

	@RequestMapping("/townerMdf.do")
	public String townerMdf(int id, final ModelMap model) {
		Owner o = ownerService.queryOwnerById(id);
		model.put("owner", o);
		model.put("m", "1");
		return "/owner/OwnerAdd";
	}

	@RequestMapping("/oMode.do")
	public void ownerM(Owner owner, HttpServletResponse response)
			throws Exception {
		int num = ownerService.updateOwner(owner);
		if (num == 1) {
			 outText(response, "0000");
		} else {
			 outText(response, "0001");
		}
	}
	@RequestMapping("/delO.do")
	public void delOwner(int id,HttpServletResponse response) throws Exception{
		int num = ownerService.deleteOwner(id);
		if (num == 1) {
			 outText(response, "0000");
		} else {
			 outText(response, "0001");
		}
	}
	@RequestMapping("/queryOwnerByName.do")
	public String queryOwnerByName(String name,final ModelMap model) throws Exception{
		System.out.println("name:"+name);
		//String nameT=new String(name.getBytes("ISO-8869-1"),"UTF-8"); 
		PageInfo<Owner> page = ownerService.querOwnerByName("%"+name+"%", 1, 6);
		model.put("page", page);
		return "/owner/mange";
	}
	
}
