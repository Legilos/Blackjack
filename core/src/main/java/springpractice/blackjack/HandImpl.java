package springpractice.blackjack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class HandImpl implements Hand {

    private final ArrayList<CardImpl> hand;
    private CardImpl card;

    public HandImpl(ArrayList<CardImpl> hand) {
        this.hand = hand;
    }


    public void addCard(CardImpl card) {
        this.card = card;
        hand.add(card);
    }

    @Override
    public boolean mustHit() {
        int total = 0;
        for (int i=0;i<hand.size();i++){
            total += hand.get(i).getValue();
        }
        if (total < 17){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isOver() {
        int total = 0;
        for (int i=0;i<hand.size();i++){
            total += hand.get(i).getValue();
        }
        if (total > 21){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void addCard() {

    }

    @Override
    public CardImpl getCard() {
        return hand.get(0);
    }

    @Override
    public CardImpl drawCard() {
        return hand.remove(0);
    }

}
