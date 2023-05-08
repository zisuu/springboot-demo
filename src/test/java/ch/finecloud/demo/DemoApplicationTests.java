package ch.finecloud.demo;

import ch.finecloud.demo.json.Greeting;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;
    @Test
    void contextLoads() {
        assertNotNull(applicationContext);
        int count = applicationContext.getBeanDefinitionCount();
        System.out.println("There are " + count + " beans in the application context");
        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    @Disabled
    void noGreetingInAppContext() {
        assertThrows(NoSuchBeanDefinitionException.class, 
                () -> applicationContext.getBean(Greeting.class));
    }

    @Test
    void getBeanTwice() {
        Greeting greeting1 = applicationContext.getBean("defaultGreeting", Greeting.class);
        Greeting greeting2 = applicationContext.getBean("defaultGreeting", Greeting.class);
        assertSame(greeting1, greeting2);
    }
}
