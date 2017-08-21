package com.em.service;

import com.em.model.Payment;
import com.github.pagehelper.PageInfo;

public interface PaymentService {
	PageInfo<Payment> queryPaymentPage(String payOwnerName,int page,int rows);
    int paymentAdd(Payment payment);
    Payment queryPaymentById(int id);
    int updatePayment(Payment payment);
    int deletePayment(int id);
    PageInfo<Payment> querPaymentByName(String name,int page,int rows);
}
