package example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/29 13:41
 */
@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }
}
