package com.example.suntory.mockito;

import com.example.suntory.NotificationClient;
import com.example.suntory.OrderRepository;
import com.example.suntory.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

// Mockito의 어노테이션에 맞게 바인딩되게 해주는 어노테이션
@ExtendWith(MockitoExtension.class)
public class MockAnnotationTests {
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private NotificationClient notificationClient;

    private OrderService orderService;

    @Test
    public void createOrderTest() {
        // given
        orderService = new OrderService(orderRepository, notificationClient);

        Mockito.when(orderRepository.findOrderList()).then(invocation -> {
            System.out.println("I'm mock orderRepository");
            return Collections.emptyList();
        });
        Mockito.doAnswer(invocation -> {
            System.out.println("I'm mock notificationClient");
            return null;
        }).when(notificationClient).notifyToMobile();

        // when
        orderService.createOrder(true);

        // then
        Mockito.verify(orderRepository, Mockito.times(1)).createOrder();
        Mockito.verify(notificationClient, Mockito.times(1)).notifyToMobile();
    }
    /**
     * Mock 어노테이션을 통한 Mock 객체 만들기
     */
}
