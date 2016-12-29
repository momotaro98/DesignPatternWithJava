package strategy;

public class CreditCard implements Payment {
    // 具象ストラテジーの1つ
    // Customerはクレジットカード利用という戦略で支払いを行う

    private String name;
    private int cardNum;

    public CreditCard(String _name, int _cardNum) {
        this.name = _name;
        this.cardNum = _cardNum;
    }

    public void make(int amount) {
        // ここでCreditCardでの戦略アルゴリズムを記述
        System.out.println("You have successfully paid $" + amount + " with credit card");
        System.out.println("Your name: " + name);
        System.out.println("Your Card Number: " + cardNum);
    }
}
