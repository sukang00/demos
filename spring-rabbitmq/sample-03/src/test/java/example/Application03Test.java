package example;

import org.example.Application03;
import org.example.publisher.Publisher1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/30 10:14
 */
@SpringBootTest(classes = Application03.class)
public class Application03Test {

    @Autowired
    private Publisher1 publisher1;
    @Test
    public void sendMessageTest() throws InterruptedException {
        publisher1.sendMessage();
    }
}
