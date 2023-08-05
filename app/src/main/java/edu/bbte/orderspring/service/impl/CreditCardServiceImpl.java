package edu.bbte.orderspring.service.impl;

import edu.bbte.orderspring.model.CreditCard;
import edu.bbte.orderspring.repository.CreditCardRepository;
import edu.bbte.orderspring.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public boolean saveAndFlush(CreditCard creditCard) {
        try {
            creditCardRepository.saveAndFlush(creditCard);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
