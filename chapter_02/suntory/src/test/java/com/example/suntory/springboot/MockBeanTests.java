package com.example.suntory.springboot;

import com.example.suntory.NotificationClient;
import com.example.suntory.OrderRepository;
import com.example.suntory.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;

@SpringBootTest // 똑같이 Springboot의 Context를 활용한 테스트를 하겠다.
public class MockBeanTests {
    @MockBean // Mock 객체를 SpringContext에 빈으로 등록
    private OrderRepository orderRepository;

    @MockBean
    private NotificationClient notificationClient;

    @Autowired // 위에서 등록한 Bean을 주입받는다.
    private OrderService orderService;

    @Test
    void createOrderTest() {
        // given
        Mockito.when(orderRepository.findOrderList()).then(invocation -> {
            System.out.println("I'm mockBean orderRepository");
            return Collections.emptyList();
        });
        Mockito.doAnswer(invocation -> {
            System.out.println("I'm mockBean notificationClient");
            return null;
        }).when(notificationClient).notifyToMobile();

        // when
        orderService.createOrder(true);

        // then
        Mockito.verify(orderRepository, Mockito.times(1)).createOrder();
        Mockito.verify(notificationClient, Mockito.times(1)).notifyToMobile();
    }
}
