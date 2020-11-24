package ingredient;

public final class Product extends Ingredient{
    static double amount;
    static boolean used;

    static void addAmount(double amountToAdd){
        amount = amount + amountToAdd;
    }

    static void subAmount(double amountToSub){
        amount = amount - amountToSub;
        if(amount <= 0){
            used = true;
        }
    }
}
