package strategy;

public class Main {

    public static void main(String[] args) {

        Customer customer = new SilverCustomer();

        // display customer account type
        customer.display();

        // set payment method with paypal and make a purchase
        // CustomerはPayPal利用という戦略で支払いを行う
        customer.setPayment(new PayPal("example@paypal.com"));
        customer.purchase(5000);

        // set payment method with credit card and make a purchase
        // Customerはクレジットカード利用という戦略で支払いを行う
        customer.setPayment(new CreditCard("John", 5824381));
        customer.purchase(2500);
    }

}
