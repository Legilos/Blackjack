package springpractice.blackjack.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springpractice.blackjack.DeckImpl;
import springpractice.blackjack.HandImpl;

@Slf4j
@Controller
public class PlayController {

    private final DeckImpl deck;
    private final HandImpl dealer;
    private int handSize = 2;
    private String temp = "";
    private boolean isOver = false;

    public PlayController(DeckImpl deck, HandImpl dealer) {
        this.deck = deck;
        this.dealer = dealer;
        deck.shuffle();

        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        System.out.println("dealer.mustHit()");
        System.out.println(dealer.mustHit());
        while (dealer.mustHit()){
            dealer.addCard(deck.drawCard());
            handSize++;
        }

        System.out.println("dealer.isOver()");
        System.out.println(dealer.isOver());
        if (dealer.isOver()){
            System.out.println("dealer.isOver()");
            System.out.println(dealer.isOver());
            isOver = true;
        }
    }

    @GetMapping("play")
    public String hello(Model model){
        log.info("play method called");
        log.info(deck.toString());
        log.info("handsize");
        log.info(String.valueOf(handSize));
        handSize++;
        for (int i = 1;i!=handSize;i++){
            temp = "value" + String.valueOf(i);
            model.addAttribute(temp, dealer.getCard().getValue());
            temp = "suit" + String.valueOf(i);
            model.addAttribute(temp, dealer.getCard().getSuit());
            temp = "face" + String.valueOf(i);
            model.addAttribute(temp, dealer.getCard().getFace());
            dealer.drawCard();
        }
        if (isOver){
            model.addAttribute("DealerOver", "The Dealer is over, you win!");
        }else{
            model.addAttribute("DealerOver", "The Dealer is not over, game on!");
        }
        return "play";
    }
}
