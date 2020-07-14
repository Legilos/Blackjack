package springpractice.blackjack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.LinkedList;

@Slf4j
@Component
public class DeckImpl implements Deck {

    Deque<CardImpl> deck
            = new LinkedList<CardImpl>();

    public DeckImpl() {
        String temp_suit = "";
        String temp_face = "";
        int card_value = 1;
        for (int i = 1; i<53; i++){
            if (i >= 40){
                temp_suit = "Hearts";
                card_value = i - 39;
            }else if (i >= 27){
                temp_suit = "Diamonds";
                card_value = i - 26;
            }else if (i >= 14){
                temp_suit = "Clubs";
                card_value = i - 13;
            }else{
                temp_suit = "Spades";
                card_value = i;
            }
            if (card_value > 10){
                if (card_value == 11){
                    temp_face = "Jack";
                }else if (card_value == 12){
                    temp_face = "Queen";
                }else if (card_value == 13){
                    temp_face = "King";
                }
                card_value = 10;
            }else{
                temp_face = String.valueOf(card_value);
            }
            if (card_value == 0){
                card_value = 1;
            }
            CardImpl card = new CardImpl(card_value, temp_suit, temp_face);
            deck.add(card);
        }
    }

    @Override
    public CardImpl getCard() {
        return deck.getFirst();
    }

    @Override
    public CardImpl drawCard() {
        return deck.pop();
    }
}
