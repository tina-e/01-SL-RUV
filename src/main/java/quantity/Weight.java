package quantity;

public class Weight extends Quantity{
    public Weight(){
        super("gram", 0);
    }

    public Weight(double gram){
        super("gram", gram);
    }
}
