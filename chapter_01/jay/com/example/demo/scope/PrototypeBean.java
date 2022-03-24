package com.example.demo.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeBean implements ScopeBean {

    @PostConstruct
    @Override
    public void afterInstanciated() {
        System.out.println("PrototypeBean.afterInstanciated : " + hashCode());
    }

    @PreDestroy
    @Override
    public void beforeDestroy() {
        System.out.println("PrototypeBean.beforeDestroy : " + hashCode());
    }

    @Override
    public String getResult() {
        return "PrototypeBean.getResult : " + hashCode();
    }
}

