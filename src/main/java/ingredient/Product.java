package ingredient;

public class Product extends Ingredient{

    private double amount;

    public Product(String name) {
        this.name = name;
    }

    public void addAmount(double amountToAdd){
        amount = amount + amountToAdd;
    }

    public void subAmount(double amountToSub){
        amount = amount - amountToSub;
        if(amount <= 0){
            this.transform("used", true);
        }
    }

    public double getAmount() {
        return amount;
    }
}
