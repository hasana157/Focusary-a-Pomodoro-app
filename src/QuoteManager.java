import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class QuoteManager {
    private List<String> quotes;
    private Random rand;

    public QuoteManager() {
        quotes = Arrays.asList(
            "The best way to get started is to quit talking and begin doing.",
            "Push yourself, because no one else is going to do it for you.",
            "Dream it. Wish it. Do it.",
            "You don’t have to be great to start, but you have to start to be great.",
            "The future depends on what you do today.",
            "The only way to do great work is to love what you do."
        );
        rand = new Random();
    }

    public String getRandomQuote() {
        return quotes.get(rand.nextInt(quotes.size()));
    }
}
