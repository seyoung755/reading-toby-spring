package dao;

@Configuration
public class CountingDaoFactory {

    @Bean
    public ArticleDao articleDao() {
        return new ArticleDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean
    public ConnectionMaker realConnectionMaker() {
        return new WooWahanArticleDao();
    }
}
