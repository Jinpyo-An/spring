package springbook.user.v2.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import springbook.user.v2.config.TestDaoFactory;
import springbook.user.v2.domain.User;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestDaoFactory.class)
class UserDaoTestV1 {

    @Autowired
    private UserDao dao;

    private User user1;
    private User user2;
    private User user3;

    @BeforeEach
    public void setUp() {
        user1 = new User("jinpyo","안진표", "spring01");
        user2 = new User("leegw700","이길원", "spring02");
        user3 = new User("bumjin","박범진", "spring03");
    }

    @Test
    @DisplayName("사용자 저장 및 조회 테스트")
    public void addAndGet() throws SQLException {
        dao.deleteAll();
        assertEquals(0, dao.getCount());

        dao.add(user1);
        dao.add(user2);
        assertEquals(2, dao.getCount());

        //when
        User findUser1 = dao.get(user1.getId());
        User findUser2 = dao.get(user2.getId());

        //then
        assertEquals(user1.getName(), findUser1.getName());
        assertEquals(user1.getName(), findUser1.getName());

        assertEquals(user2.getName(), findUser2.getName());
        assertEquals(user2.getName(), findUser2.getName());
    }

    @Test()
    @DisplayName("사용자 조회 테스트 실패")
    public void getUserFailure() throws SQLException {
        dao.deleteAll();
        assertEquals(0, dao.getCount());

        assertThrows(EmptyResultDataAccessException.class, () -> dao.get("unknown_id"));
    }

    @Test
    @DisplayName("사용자 저장 개수 테스트")
    public void count() throws SQLException {
        dao.deleteAll();
        assertEquals(0, dao.getCount());

        dao.add(user1);
        assertEquals(1, dao.getCount());

        dao.add(user2);
        assertEquals(2, dao.getCount());

        dao.add(user3);
        assertEquals(3, dao.getCount());
    }
}