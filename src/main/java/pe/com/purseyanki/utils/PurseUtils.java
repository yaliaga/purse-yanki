package pe.com.purseyanki.utils;

import org.springframework.beans.BeanUtils;

import pe.com.purseyanki.model.Purse;
import pe.com.purseyanki.model.dto.PurseDto;


public class PurseUtils {
	private PurseUtils() {
    }

    public static PurseDto entityToDto(final Purse customer) {
        var purseDto = new PurseDto();
        BeanUtils.copyProperties(customer, purseDto);
        return purseDto;
    }
    public static Purse dtoToEntity(final PurseDto purseDto) {
        var entity = new Purse();
        BeanUtils.copyProperties(purseDto, entity);
        return entity;
}
}
