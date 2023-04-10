package tobby;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	@Bean
	public UserDaoClass userDao() {
		return new UserDaoClass(connectionMaker());
	}

	public ConnectionMaker connectionMaker() {
		return new SimpleConnectionMaker() {
		};
	}
}

