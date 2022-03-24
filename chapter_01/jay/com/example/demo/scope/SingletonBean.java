package com.example.demo.scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SingletonBean implements ScopeBean {

    @PostConstruct
    @Override
    public void afterInstanciated() {
        System.out.println("SingletonBean.afterInstanciated : " + hashCode());
    }

    @PreDestroy
    @Override
    public void beforeDestroy() {
        System.out.println("SingletonBean.beforeDestroy : " + hashCode());
    }

    @Override
    public String getResult() {
        return "SingletonBean.getResult : " + this.hashCode();
    }
}
