package redisdemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisRepositoryTest {

	@Autowired
	RedisRepository repository;

	@AfterEach
	void tearDown() {

	}

	@Test
	void 생성(){
		Room room = new Room(1, 1);
		repository.save(room);

		repository.save(new Room(2, 2));
	}
}
