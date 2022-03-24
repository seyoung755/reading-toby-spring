package com.example.demo.config;

import com.example.demo.scope.PrototypeBean;
import com.example.demo.scope.SingletonBean;
import com.example.demo.scope.web.ApplicationScopeBean;
import com.example.demo.scope.web.RequestScopeBean;
import com.example.demo.scope.web.SessionScopeBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class AppConfig {

    @Bean
//    @Scope("singleton")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    @Bean
//    @Scope("prototype")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }

    @Bean
//    @Scope("request")
    @Scope(value = WebApplicationContext.SCOPE_REQUEST)
//    @RequestScope
    public RequestScopeBean requestScopeBean() {
        return new RequestScopeBean();
    }

    @Bean
//    @Scope("session")
    @Scope(value = WebApplicationContext.SCOPE_SESSION)
//    @SessionScope
    public SessionScopeBean sessionScopeBean() {
        return new SessionScopeBean();
    }

    @Bean
//    @Scope("application")
    @Scope(value = WebApplicationContext.SCOPE_APPLICATION)
//    @ApplicationScope
    public ApplicationScopeBean applicationScopeBean() {
        return new ApplicationScopeBean();
    }

}
