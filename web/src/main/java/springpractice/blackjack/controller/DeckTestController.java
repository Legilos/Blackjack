package springpractice.blackjack.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springpractice.blackjack.DeckImpl;

@Slf4j
@Controller
public class DeckTestController {

    private final DeckImpl deck;

    @Autowired
    public DeckTestController(DeckImpl deck) {
        this.deck = deck;
    }

    @GetMapping("deck-test")
    public String hello(Model model){
        log.info("deck-test method called");
        log.info(deck.toString());
        model.addAttribute("value", deck.getCard().getValue());
        model.addAttribute("suit", deck.getCard().getSuit());
        model.addAttribute("face", deck.getCard().getFace());
        deck.drawCard();
        return "deck-test";
    }
}
