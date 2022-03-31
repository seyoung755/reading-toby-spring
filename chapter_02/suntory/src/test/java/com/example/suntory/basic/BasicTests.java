package com.example.suntory.basic;

import com.example.suntory.NotificationClient;
import com.example.suntory.OrderRepository;
import com.example.suntory.OrderService;
import org.junit.jupiter.api.Test;

public class BasicTests {
    private OrderService orderService;

    @Test
    void createOrderTest() {
        // 의존성 추가
        OrderRepository orderRepository = new OrderRepository();
        NotificationClient notificationClient = new NotificationClient();

        orderService = new OrderService(orderRepository, notificationClient);

        orderService.createOrder(true);
    }
    /**
     * 이 테스트에서 선행되어야할 조건
     * - repository가 사용할 RDB connection 세팅
     * - RDB에 로직 테스트 조건에 맞는 데이터 세팅
     * - NotificationClient가 사용할 Notification Server 연결
     * - Notification이 성공했을 때의 데이터 롤백 처리
     */

}
