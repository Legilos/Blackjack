package springpractice.blackjack;


import org.springframework.stereotype.Service;

@Service
public class ServicesImpl implements Services {

    @Override
    public String getMessage() {
        return "Hello World";
    }
}
