package com.szh.springcloud.dao;

import com.szh.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 *
 */
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
