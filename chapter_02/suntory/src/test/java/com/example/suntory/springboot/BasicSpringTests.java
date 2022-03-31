package com.example.suntory.springboot;

import com.example.suntory.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // Springboot의 Context를 활용한 테스트를 하겠다.
public class BasicSpringTests {

    @Autowired // ApplicationContext에 등록된 bean을 의존성을 추가해준다.
    private OrderService orderService;

    @Test
    void createOrderTest() {
        orderService.createOrder(true);
    }
}

/**
 * 물론 이 방법이 가장 편하긴 하지만, 맨 처음 예시와 같이 실제 코드가 동작하기 위해서 사전작업이 많이 필요하다.
 */
