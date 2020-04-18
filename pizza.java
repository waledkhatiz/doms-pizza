import java.util.ArrayList; 
import java.util.List;

public class pizza{
    String[] crust = {"cheeseStuffed", "original", "deepDish"};
    Double[] crustPrice = {2.0, 0.5, 1.0};
    String[] meat = {"vegan", "chicken", "beef", "pepperoni"};
    Double[] meatPrice = {10.0, 9.0, 10.5, 9.0};
    String[] extra = {"tomato", "onion", "capsicum", "olives", "spinach", "cheese", "bacon"};

    String chosenCrust;
    Double currentPrice;
    String chosenMeat;
    List<String> chosenExtra = new ArrayList<String>();

    public void setCrust(int xCrust) {
        this.chosenCrust = crust[xCrust];
        currentPrice = currentPrice + crustPrice[xCrust]; 
    }

    public String getCrust() {
        return chosenCrust;
    }

    public void setMeat(int xMeat) {
        this.chosenMeat = meat[xMeat];
        currentPrice = currentPrice + meatPrice[xMeat];
    }

    public String getMeat() {
        return chosenMeat;
    }

    public void addExtra(int xExtra) {
        chosenExtra.add(extra[xExtra]);
        currentPrice = currentPrice + 1.5;
    }

    public Object[] getExtra() {
        return chosenExtra.toArray();
    }
}