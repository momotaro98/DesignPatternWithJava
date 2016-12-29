package strategy;

public class PayPal implements Payment {
    // 具象ストラテジーの1つ
    // CustomerはPayPal利用という戦略で支払いを行う

    private String email;

    public PayPal(String _email) {
        this.email = _email;
    }

    public void make(int amount) {
        // ここでPayPalでの戦略アルゴリズムを記述
        System.out.println("You have successfully paid $" + amount + " with paypal");
        System.out.println("Paypal Email: " + email);
    }
}
