package com.example.demo.scope.web;

import com.example.demo.scope.ScopeBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ApplicationScopeBean implements ScopeBean {

    @PostConstruct
    @Override
    public void afterInstanciated() {
        System.out.println("ApplicationScopeBean.afterInstanciated : " + hashCode());
    }

    @PreDestroy
    @Override
    public void beforeDestroy() {
        System.out.println("ApplicationScopeBean.beforeDestroy : " + hashCode());
    }

    @Override
    public String getResult() {
        return "ApplicationScopeBean.getResult : " + hashCode();
    }
}
