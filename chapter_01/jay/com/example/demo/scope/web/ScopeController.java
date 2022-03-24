package com.example.demo.scope.web;

import com.example.demo.scope.ScopeBean;
import com.example.demo.scope.ScpoeBeanFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeController {

    private final ScpoeBeanFactory scpoeBeanFactory;

    public ScopeController(ScpoeBeanFactory scpoeBeanFactory) {
        this.scpoeBeanFactory = scpoeBeanFactory;
    }

    @GetMapping("/singleton")
    public String singleton() {
        return getScopeBean(ScpoeBeanFactory.SINGLETON);
    }

    @GetMapping("/prototype")
    public String prototype() {
        return getScopeBean(ScpoeBeanFactory.PROTOTYPE);
    }

    @GetMapping("/request")
    public String request() {
        return getScopeBean(ScpoeBeanFactory.REQUEST);
    }

    @GetMapping("/session")
    public String session() {
        return getScopeBean(ScpoeBeanFactory.SESSION);
    }

    @GetMapping("/application")
    public String application() {
        return getScopeBean(ScpoeBeanFactory.APPLICATION);
    }

    private String getScopeBean(String name) {
        ScopeBean bean = scpoeBeanFactory.getBeanByType(name);

        if (bean == null) {
            System.out.println("bean not matched");
            return "bean not matched";
        }

        System.out.println(bean.getResult());

        return bean.getResult();
    }

}
