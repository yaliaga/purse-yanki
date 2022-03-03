package pe.com.purseyanki.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("purse")
public class Purse implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String cardId;
}
