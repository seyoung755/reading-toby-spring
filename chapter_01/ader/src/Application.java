import dao.ArticleDao;
import dao.CountingConnectionMaker;
import dao.CountingDaoFactory;
import dao.DaoFactory;
import domain.Article;

import java.sql.SQLException;
import java.time.LocalDateTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DaoFactory.class);

        ArticleDao articleDao = ac.getBean("articleDao", ArticleDao.class);

        Article article = new Article();
        article.setId(1L);
        article.setWriter("ader");
        article.setTitle("title test");
        article.setContents("contents test");
        article.setCreatedTime(LocalDateTime.now());
        article.setUpdatedTime(LocalDateTime.now());

        articleDao.add(article);
        System.out.println("등록 성공");

        Article findArticle = articleDao.get(article.getId());
        System.out.println("findArticle.getWriter() = " + findArticle.getWriter());
        System.out.println("findArticle.getTitle() = " + findArticle.getTitle());

        System.out.println(findArticle.getId() + " 조회 성공");

        System.out.println("1-6 싱글톤 확인을 위한 출력");
        DaoFactory factory = new DaoFactory();
        ArticleDao articleDao1 = factory.articleDao();
        ArticleDao articleDao2 = factory.articleDao();

        System.out.println("---일반적으로 생성---");
        System.out.println(articleDao1);
        System.out.println(articleDao2);

        System.out.println("---스프링 컨텍스트에서 가져옴---");
        ArticleDao articleDao3 = ac.getBean("articleDao", ArticleDao.class);
        ArticleDao articleDao4 = ac.getBean("articleDao", ArticleDao.class);
        System.out.println(articleDao3);
        System.out.println(articleDao4);

        System.out.println("---카운팅 dao 사용---");
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        ArticleDao articleDao5 = acac.getBean("articleDao", ArticleDao.class);

        CountingConnectionMaker ccm = acac.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection count = " + ccm.getCounter());
    }
}
