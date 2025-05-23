package springbook.user.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.user.v2.config.DaoFactory;
import springbook.user.v2.dao.UserDao;
import springbook.user.v2.domain.User;

import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }
}
