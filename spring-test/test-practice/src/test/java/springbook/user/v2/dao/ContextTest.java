package springbook.user.v2.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import springbook.user.v2.config.TestContextFactory;

import static org.assertj.core.api.Assertions.*;

@ContextConfiguration(classes = TestContextFactory.class)
class ContextTest {

    @Autowired
    ApplicationContext context;

    static ApplicationContext contextObject;

    @Test
    void test1() {
        assertThat(contextObject == null || contextObject == context).isTrue();
        contextObject = context;
    }

    @Test
    void test2() {
        assertThat(contextObject == null || contextObject == context).isTrue();
        contextObject = context;
    }

    @Test
    void test3() {
        assertThat(contextObject == null || contextObject == context).isTrue();
        contextObject = context;
    }
}
