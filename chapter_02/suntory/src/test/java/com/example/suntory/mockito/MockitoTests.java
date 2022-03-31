package com.example.suntory.mockito;

import com.example.suntory.NotificationClient;
import com.example.suntory.OrderRepository;
import com.example.suntory.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

public class MockitoTests {
    private OrderService orderService;

    /**
     * 이 테스트의 실제 관심사
     * - orderRepository.findOrderList()의 결과가 존재할 때 예외가 발생하는지
     * - orderRepository.createOrder()가 1번 실행됐는지
     * - isNotify에 따라서 알림이 가는지
     */

    @Test
    public void createOrderTest() {
        // given
        OrderRepository orderRepository = Mockito.mock(OrderRepository.class);
        NotificationClient notificationClient = Mockito.mock(NotificationClient.class);
        orderService = new OrderService(orderRepository, notificationClient);

        Mockito.when(orderRepository.findOrderList()).then(invocation -> {
            System.out.println("I'm mock orderRepository");
            return Collections.emptyList();
        });
        Mockito.doAnswer(invocation -> {
            System.out.println("I'm mock notificationclient");
            return null;
        }).when(notificationClient).notifyToMobile();

        // when
        orderService.createOrder(true);

        // then
        Mockito.verify(orderRepository, Mockito.times(1)).createOrder();
        Mockito.verify(notificationClient, Mockito.times(1)).notifyToMobile();
    }
    /**
     * 함수를 실행하면 실제로는 stub이 실행된다.
     * verify를 통해 Mockito framework가 spy를 통해 몇회 호출되었는지를 검증해주었다.
     * 의문점: orderRepository의 createOrder는 아무 stub을 작성하지 않았는데 잘 성공헀다.
     * 이는 Mockito의 메소드의 type별 정의된 DEFAULT 메소드 덕분이다.
     * 기본전략이 Answers.RETURNS_DEFAULTS 이기 때문이다. return type이 void인 DEFAULT 메소드가 대신 실행되었다.
     */
}
