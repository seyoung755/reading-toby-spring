package com.example.demo.scope.web;

import com.example.demo.scope.ScopeBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class RequestScopeBean implements ScopeBean {

    @PostConstruct
    @Override
    public void afterInstanciated() {
        System.out.println("RequestScopeBean.afterInstanciated : " + hashCode());
    }

    @PreDestroy
    @Override
    public void beforeDestroy() {
        System.out.println("RequestScopeBean.beforeDestroy : " + hashCode());
    }

    @Override
    public String getResult() {
        return "RequestScopeBean.getResult : " + hashCode();
    }
}
