package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public ArticleDao articleDao() {
        return new ArticleDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new WooWahanArticleDao();
    }
}
