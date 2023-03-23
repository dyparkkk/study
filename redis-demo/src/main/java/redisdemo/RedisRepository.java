package redisdemo;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository{

	private final RedisCrudRepository repository;
	private final StringRedisTemplate stringRedisTemplate;

	public RedisRepository(RedisCrudRepository repository, StringRedisTemplate stringRedisTemplate) {
		this.repository = repository;
		this.stringRedisTemplate = stringRedisTemplate;
	}

	public Room save(Room room){
		// room:channelServer:<channelId> set 추가
		String key = String.format("room:channelServer:%d", room.getChannelId());
		String value = String.valueOf(room.getId());
		SetOperations<String, String> stringStringSetOperations = stringRedisTemplate.opsForSet();
		stringStringSetOperations.add(key, value);

		return repository.save(room);
	}
}
