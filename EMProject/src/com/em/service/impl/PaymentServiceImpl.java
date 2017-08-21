package com.em.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.em.mapper.PaymentMapper;
import com.em.model.Owner;
import com.em.model.Payment;
import com.em.service.PaymentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
	@Override
	public PageInfo<Payment> queryPaymentPage(String paymentOwnerName, int page,
			int rows) {
		// TODO Auto-generated method stub
		if(paymentOwnerName!=null){
			Payment payment=new Payment();
			payment.setPaymentOwnerName(paymentOwnerName);
	        PageHelper.startPage(page, rows);  
	        PageInfo<Payment> pages = new PageInfo<Payment>(paymentMapper.select(payment));  
	        return pages;  	
		}else{
			 PageHelper.startPage(page, rows);  
		     PageInfo<Payment> pages = new PageInfo<Payment>(paymentMapper.selectAll());  
		     return pages;  	
		}
	}

	@Override
	public int paymentAdd(Payment payment) {
		// TODO Auto-generated method stub
		return paymentMapper.insertSelective(payment);
	}

	@Override
	public Payment queryPaymentById(int id) {
		// TODO Auto-generated method stub
		Payment o=new Payment();
		o.setId(id);
		o=paymentMapper.selectByPrimaryKey(o);
		return o;
	}

	@Override
	public int updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		return paymentMapper.updateByPrimaryKeySelective(payment);
	}

	@Override
	public int deletePayment(int id) {
		// TODO Auto-generated method stub
		Payment o=new Payment();
		o.setId(id);
		return paymentMapper.deleteByPrimaryKey(o);
	}

	@Override
	public PageInfo<Payment> querPaymentByName(String name, int page, int rows) {
		// TODO Auto-generated method stub
		Example ex=new Example(Payment.class);
		Example.Criteria criteria=ex.createCriteria();
		criteria.andLike("paymentOwnerName", name);
        PageHelper.startPage(page, rows);  
        PageInfo<Payment> pages = new PageInfo<Payment>(paymentMapper.selectByExample(ex));  
        return pages;  	
	}

}
