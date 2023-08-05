package edu.bbte.orderspring.controller;

import edu.bbte.orderspring.controller.exception.NotFoundException;
import edu.bbte.orderspring.dto.incoming.CreditCardSave;
import edu.bbte.orderspring.mapper.CreditCardMapper;
import edu.bbte.orderspring.model.CreditCard;
import edu.bbte.orderspring.model.User;
import edu.bbte.orderspring.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api")
public class CreditCardController {
    @Autowired
    private UserService userService;

    @Autowired
    private CreditCardMapper creditCardMapper;

    @PostMapping(path="/cards")
    public boolean saveCard(@RequestBody @Valid CreditCardSave creditCardSave) {
        User user = userService.findById(Long.valueOf(creditCardSave.getUserId())).orElseThrow(NotFoundException::new);
        CreditCard creditCard = creditCardMapper.inputDtoToModel(creditCardSave);
        creditCard.setUser(user);
        int before = user.getCreditCards().size();
        user.getCreditCards().add(creditCard);
        userService.saveAndFlush(user);
        int after = user.getCreditCards().size();
        return after > before;
    }
}
