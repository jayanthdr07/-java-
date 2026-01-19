import java.util.*;
public class ShoppingCart {
    public void addItem(String itemName) {
        System.out.println(itemName+" added to the cart");
    }
    public void addItem(String itemName,int quantity){
        System.out.println(quantity+" "+itemName+"s added to the cart");
    }
    public void addItem(String itemName,int quantity,double price){
        double totalCost=quantity*price;
        System.out.println(quantity+" "+itemName+"s added to the cart. Total cost: $"+totalCost);
    }
    public static void main(String[] args){
        //creating new instance of the class shoppingCart
        ShoppingCart cart=new ShoppingCart();
        cart.addItem("T-Shirt");
        cart.addItem("Shoe",2);
        cart.addItem("Sunglasses",3,25.99);
    }
}