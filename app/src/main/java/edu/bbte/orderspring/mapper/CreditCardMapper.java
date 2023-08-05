package edu.bbte.orderspring.mapper;

import edu.bbte.orderspring.dto.incoming.CreditCardSave;
import edu.bbte.orderspring.model.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CreditCardMapper {

    @Mapping(target = "id", ignore = true)
    CreditCard inputDtoToModel(CreditCardSave creditCardInputDto);
}
