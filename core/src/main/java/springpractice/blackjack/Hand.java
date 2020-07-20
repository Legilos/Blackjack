package springpractice.blackjack;

public interface Hand {
    public CardImpl getCard();
    public CardImpl drawCard();
    boolean mustHit();
    boolean isOver();
    void addCard();
}
