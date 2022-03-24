package com.example.demo.scope.web;

import com.example.demo.scope.ScopeBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SessionScopeBean implements ScopeBean {

    @PostConstruct
    @Override
    public void afterInstanciated() {
        System.out.println("SessionScopeBean.afterInstanciated : " + hashCode());
    }

    @PreDestroy
    @Override
    public void beforeDestroy() {
        System.out.println("SessionScopeBean.beforeDestroy : " + hashCode());
    }

    @Override
    public String getResult() {
        return "SessionScopeBean.getResult : " + hashCode();
    }
}
