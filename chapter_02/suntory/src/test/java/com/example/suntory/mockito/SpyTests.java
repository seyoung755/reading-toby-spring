package com.example.suntory.mockito;

import com.example.suntory.NotificationClient;
import com.example.suntory.OrderRepository;
import com.example.suntory.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpyTests {
    /**
     * Spy를 사용하면 하나의 객체를 선택적으로 Stub할 수 있다.
     * orderRepository의 findOrderList는 원래 기능을 사용하고,
     * createOrder에 대해서만 stub을 적용한 예시이다.
     */
    @Spy
    private OrderRepository orderRepository;

    @Spy
    private NotificationClient notificationClient;

    @InjectMocks
    private OrderService orderService;

    @Test
    void createOrderTest() {
        // given
        Mockito.doAnswer(invocation -> {
            System.out.println("I'm spy orderRepository createOrder");
            return null;
        }).when(orderRepository).createOrder();
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
