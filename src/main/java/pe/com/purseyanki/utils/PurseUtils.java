package pe.com.purseyanki.utils;

import org.springframework.beans.BeanUtils;

import pe.com.purseyanki.model.Purse;
import pe.com.purseyanki.model.dto.PurseDto;


public class PurseUtils {
	private PurseUtils() {
    }

    public static PurseDto entityToDto(final Purse customer) {
        var walletDto = new PurseDto();
        BeanUtils.copyProperties(customer, walletDto);
        return walletDto;
    }
    public static Purse dtoToEntity(final PurseDto purseDto) {
        var entity = new Purse();
        BeanUtils.copyProperties(purseDto, entity);
        return entity;
}
}
