package pdp.uz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pdp.uz.service.CardService;

@Controller
@RequestMapping("/card")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

//    @Autowired
//    private CardService cardService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("list", cardService.getList());
//        model.addAttribute("list", 12344);
        return "card" ;
    }
}
