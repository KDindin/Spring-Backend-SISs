package backend.spring.springboottesting;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootTestingApplication.class)
class SpringBootTestingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void whenSpringContextIsBootstrapped_thenNoExceptions() {
	}

}
