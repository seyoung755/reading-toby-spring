package com.example.suntory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class OrderRepository {
    private static final Logger log = LoggerFactory.getLogger(OrderRepository.class);
    public List<Order> findOrderList() {
        log.info("real OrderRepository findOrderList");
        return Collections.emptyList();
    }

    public void createOrder() {
        log.debug("createOrder success");
    }
}
