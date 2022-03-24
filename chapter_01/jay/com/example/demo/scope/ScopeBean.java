package com.example.demo.scope;

public interface ScopeBean {

    void afterInstanciated();
    void beforeDestroy();
    String getResult();

}
