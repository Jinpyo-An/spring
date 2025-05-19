package springbook.user.v2.dao;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JunitTestV1 {
    public static JunitTestV1 testObject;

    @Test
    public void test1() {
        assertThat(testObject).isNotSameAs(this);
        testObject = this;
    }

    @Test
    public void test2() {
        assertThat(testObject).isNotSameAs(this);
        testObject = this;
    }

    @Test
    public void test3() {
        assertThat(testObject).isNotSameAs(this);
        testObject = this;
    }
}
