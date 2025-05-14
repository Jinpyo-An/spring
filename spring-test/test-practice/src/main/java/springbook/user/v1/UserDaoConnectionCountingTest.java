package springbook.user.v1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.v1.dao.CountingConnectionMaker;
import springbook.user.v1.dao.CountingDaoFactory;
import springbook.user.v1.dao.UserDao;

public class UserDaoConnectionCountingTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        // DAO 사용 코드

        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter: " + ccm.getCounter());
    }
}
