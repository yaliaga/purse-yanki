package pe.com.purseyanki.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurseDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String cardId;
}
