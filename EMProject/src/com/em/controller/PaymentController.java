package com.em.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.em.model.Payment;
import com.em.service.PaymentService;
import com.github.pagehelper.PageInfo;

@Controller
public class PaymentController extends BaseController{
	@Resource
	private PaymentService paymentService;
	
	@RequestMapping("/toPAdd.do")
	public String toOwnerAdd() {
		return "/payment/PaymentAdd";
	}

	@RequestMapping("/pAdd.do")
	public void paymentAdd(Payment payment, HttpServletResponse response)
			throws Exception {
		int num = paymentService.paymentAdd(payment);
		if (num == 1) {
			 outText(response, "0000");
		} else {
			 outText(response, "0001");
		}
	}
    @RequestMapping("listPaymentByNum.do")
    public String listPaymentByNum(final ModelMap model,int num){
    	PageInfo<Payment> page = paymentService.queryPaymentPage(null, num, 6);
		model.put("page", page);
		return "/payment/mange";
    }
    
	@RequestMapping("/listPayment.do")
	public String listPayment(final ModelMap model) {
		PageInfo<Payment> page = paymentService.queryPaymentPage(null, 1, 6);
		model.put("page", page);
		return "/payment/mange";
	}

	@RequestMapping("/toPaymentMdf.do")
	public String townerMdf(int id, final ModelMap model) {
		Payment o = paymentService.queryPaymentById(id);
		model.put("payment", o);
		model.put("m", "1");
		return "/payment/PaymentAdd";
	}

	@RequestMapping("/pMode.do")
	public void ownerM(Payment owner, HttpServletResponse response)
			throws Exception {
		int num = paymentService.updatePayment(owner);
		if (num == 1) {
			 outText(response, "0000");
		} else {
			 outText(response, "0001");
		}
	}
	@RequestMapping("/delP.do")
	public void delPayment(int id,HttpServletResponse response) throws Exception{
		int num = paymentService.deletePayment(id);
		if (num == 1) {
			 outText(response, "0000");
		} else {
			 outText(response, "0001");
		}
	}
	@RequestMapping("/queryPaymentByName.do")
	public String queryPaymentByName(String name,final ModelMap model) throws Exception{
		System.out.println("name:"+name);
		//String nameT=new String(name.getBytes("ISO-8869-1"),"UTF-8"); 
		PageInfo<Payment> page = paymentService.querPaymentByName("%"+name+"%", 1, 6);
		model.put("page", page);
		return "/payment/mange";
	}
	
	

}
