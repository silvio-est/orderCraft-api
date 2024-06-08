package ordercraft.com.application;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = CucumberTest.class)
public class CucumberSpringConfiguration {
}
