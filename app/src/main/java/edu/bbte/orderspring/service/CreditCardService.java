package edu.bbte.orderspring.service;

import edu.bbte.orderspring.model.CreditCard;
import org.springframework.stereotype.Service;

@Service
public interface CreditCardService {
    boolean saveAndFlush(CreditCard creditCard);
}
