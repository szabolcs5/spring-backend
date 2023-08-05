package edu.bbte.orderspring.mapper;

import edu.bbte.orderspring.dto.incoming.CreditCardSave;
import edu.bbte.orderspring.model.CreditCard;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-05T21:44:49+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class CreditCardMapperImpl implements CreditCardMapper {

    @Override
    public CreditCard inputDtoToModel(CreditCardSave creditCardInputDto) {
        if ( creditCardInputDto == null ) {
            return null;
        }

        CreditCard creditCard = new CreditCard();

        creditCard.setCardNumber( creditCardInputDto.getCardNumber() );
        creditCard.setCardHolder( creditCardInputDto.getCardHolder() );
        creditCard.setExpirationDate( creditCardInputDto.getExpirationDate() );
        creditCard.setCvc( creditCardInputDto.getCvc() );

        return creditCard;
    }
}
