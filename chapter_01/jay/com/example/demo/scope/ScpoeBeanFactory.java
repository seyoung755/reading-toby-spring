package com.example.demo.scope;

import com.example.demo.scope.web.ApplicationScopeBean;
import com.example.demo.scope.web.RequestScopeBean;
import com.example.demo.scope.web.SessionScopeBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ScpoeBeanFactory {

    public static final String SINGLETON = "singleton";
    public static final String PROTOTYPE = "prototype";
    public static final String REQUEST = "request";
    public static final String SESSION = "session";
    public static final String APPLICATION = "application";

    private final ApplicationContext context;

    public ScpoeBeanFactory(ApplicationContext context) {
        this.context = context;
    }

    public ScopeBean getBeanByType(String type) {
        switch (type) {
            case SINGLETON: return context.getBean(SingletonBean.class);
            case PROTOTYPE: return context.getBean(PrototypeBean.class);
            case REQUEST: return context.getBean(RequestScopeBean.class);
            case SESSION: return context.getBean(SessionScopeBean.class);
            case APPLICATION: return context.getBean(ApplicationScopeBean.class);
            default: return null;
        }
    }
}
