public class pizza {
    private String[] pizzaType = {"Pepperoni", "Italian", "Cheese", "Meat Lovers"};
    private Double[] typePrice = {19.99, 15.49, 10.99, 17.49};
    private String[] pizzaCrust = {"Traditional", "Cheese-Stuffed", "Thin"};
    private Double[] crustPrice = {0.00, 2.00, 1.00};
    private String[] pizzaSauce = {"None", "Tomato", "Barbecue", "Chilli"};
    private Integer chosenType = 0;
    private Integer chosenCrust = 0;
    private Integer chosenSauce = 0;
    private Double currentPrice = 19.99;
    
    public void setType(int typeNum){
        this.chosenType = typeNum;
        System.out.println(" + $" + typePrice[typeNum]);
    }

    public Integer getType() {
        return chosenType;
    }

    public void setCrust(int crustNum){
        this.chosenCrust = crustNum;
        System.out.println(" + $" + crustPrice[crustNum]);
    }

    public Integer getCrust(){
        return chosenCrust;
    }

    public void setSauce(int sauceNum) {
        this.chosenSauce = sauceNum;
    }

    public Integer getSauce() {
        return chosenSauce;
    }

    public Double getPrice() {
        currentPrice = 0.0;
        currentPrice += typePrice[chosenType];
        currentPrice += crustPrice[chosenCrust];
        return currentPrice;
    }

    public String getOrderString() {
        String orderString = "Type: " + pizzaType[chosenType] + " || Sauce: " + pizzaSauce[chosenSauce] + 
                                " || Crust: " + pizzaCrust[chosenCrust] + " || $" + currentPrice;
        return orderString;
    }
}