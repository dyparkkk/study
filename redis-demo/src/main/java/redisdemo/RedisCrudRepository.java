package redisdemo;

import org.springframework.data.repository.CrudRepository;

public interface RedisCrudRepository extends CrudRepository<Room, Integer> {
}
