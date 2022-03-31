package com.example.suntory.springboot;

import com.example.suntory.NotificationClient;
import com.example.suntory.OrderRepository;
import com.example.suntory.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.Collections;

@SpringBootTest
class SpyBeanTests {
    @SpyBean // 프록시 객체를 통해 Spy 기능을 추가한다.
    private OrderRepository orderRepository;
    @SpyBean
    private NotificationClient notificationClient;
    @Autowired
    private OrderService orderService;

    @Test
    void createOrderTest() {
        // given
        Mockito.when(orderRepository.findOrderList()).then(invocation -> {
            System.out.println("I'm spy orderRepository");
            return Collections.emptyList();
        });
        Mockito.doAnswer(invocation -> {
            System.out.println("I'm spy notificationClient");
            return null;
        }).when(notificationClient).notifyToMobile();

        // when
        orderService.createOrder(true);

        // then
        Mockito.verify(orderRepository, Mockito.times(1)).createOrder();
        Mockito.verify(notificationClient, Mockito.times(1)).notifyToMobile();
    }
}
