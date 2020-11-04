package beer;

import java.util.Random;

public class Beer {

    public static final Beer instance = new Beer();

    private int amount;

    private Beer() {
        amount = new Random().nextInt(4);
    }

    public String giveBeer() {
        if(amount > 0) {
            amount--;
            return "Student will be given a glass of beer instead of being expelled";
        } else {
            return "Student isn't going to be expelled, but there's no beer left";
        }
    }

    public int getAmount() {
        return amount;
    }
}
