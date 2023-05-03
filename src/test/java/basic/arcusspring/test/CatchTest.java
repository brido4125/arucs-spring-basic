package basic.arcusspring.test;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CatchTest {

    void exceptionFunc() {
        throw new RuntimeException("HI");
    }

    @Test
    void catchTest() {
        try {
            exceptionFunc();
        }catch (Exception e) {
            System.out.println("catch");
        }
        System.out.println("After catch");
    }

}
