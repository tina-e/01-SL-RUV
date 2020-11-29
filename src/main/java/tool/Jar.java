package tool;

import config.Constants;

public class Jar extends Kitchentool{

    public static final int TOTAL_SPACE = 100;
    private int space;

    public Jar() {
        super(Constants.JAR);
        space = TOTAL_SPACE;
    }

    public void addAmount(int amount) {
        space -= amount;
    }

    public int getSpace() {
        return space;
    }

    public void resetSpace() {
        this.space = TOTAL_SPACE;
    }
}
