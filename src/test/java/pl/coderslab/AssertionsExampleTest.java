package pl.coderslab;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertionsExampleTest {
    @Test
    public void shouldTeachAssertions() {
        // given
        // when
        // then
        assertTrue(2==2);
        Assertions.assertFalse(false);
        Assertions.assertEquals(42, 42);
        Assertions.assertEquals(3.14, 3.14, .01);
        boolean myCustomCondition = false;
        if(myCustomCondition) {
            Assertions.fail("this will always fail");
        }
    }
}
