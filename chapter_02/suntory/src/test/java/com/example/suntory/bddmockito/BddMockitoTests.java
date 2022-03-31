package com.example.suntory.bddmockito;

import com.example.suntory.NotificationClient;
import com.example.suntory.OrderRepository;
import com.example.suntory.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Collections;

public class BddMockitoTests {

    private OrderService orderService;

    @Test
    public void createOrderTest() {
        // given
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        NotificationClient notificationClient = Mockito.mock(NotificationClient.class);
        orderService = new OrderService(orderRepository, notificationClient);
        // 원래 when -> then에서, BDD의 흐름에 맞게 given -> will로 바뀌었다.
        BDDMockito.given(orderRepository.findOrderList()).will(invocation -> {
            System.out.println("I'm mock orderRepository");
            return Collections.emptyList();
        });

        // 원래 doAnswer -> when 이었는데, BDD의 흐름에 맞게 willAnswer -> given으로 바뀜
        BDDMockito.willAnswer(invocation -> {
            System.out.println("I'm mock notificationclient");
            return null;
        }).given(notificationClient).notifyToMobile();

        // when
        orderService.createOrder(true);

        // then
        // 원래 verify였지만 BDD의 흐름에 맞게, then -> should 문법 사용
        BDDMockito.then(orderRepository).should(BDDMockito.times(1)).createOrder();
        BDDMockito.then(notificationClient).should(BDDMockito.times(1)).notifyToMobile();
    }
}
