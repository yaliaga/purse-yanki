package pe.com.purseyanki.repository;

import java.util.UUID;

import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import pe.com.purseyanki.model.Purse;
import pe.com.purseyanki.model.dto.PurseDto;
import pe.com.purseyanki.utils.PurseUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class PurseRepository {

	public static final String HASH_KEY = "purse";

	private ReactiveRedisTemplate reactiveRedisTemplate;

	public Mono<PurseDto> create(final Mono<PurseDto> entityToDto) {

		Mono<PurseDto> result = entityToDto.map(p -> {
			if (p.getId() != null) {
				String id = UUID.randomUUID().toString();
				p.setId(id);
			}
			return p;
		});

		return reactiveRedisTemplate.<String, Purse>opsForHash().put(HASH_KEY, result.map(PurseDto::getId), result)
				.log().map(p -> entityToDto);
	}

	public Flux<PurseDto> read() {
		ReactiveHashOperations<String, String, Purse> val = reactiveRedisTemplate.opsForHash();
		return val.values(HASH_KEY).map(PurseUtils::entityToDto);
	}

	public Mono<PurseDto> findById(String id) {
		return reactiveRedisTemplate.<String, Purse>opsForHash().get(HASH_KEY, id);
	}

	public Mono<Void> delete(String id) {
		return reactiveRedisTemplate.<String, Purse>opsForHash().delete(HASH_KEY).flatMap(p -> Mono.<Void>empty());
	}

}
