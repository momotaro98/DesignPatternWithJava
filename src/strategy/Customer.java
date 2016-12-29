package strategy;

public abstract class Customer {
    // CustomerはPaymentを実装したインスタンスを委譲し(paymentを取得)、
    // purchase()メソッド内のpayment.make()で戦略を実行
    // setPayment()で戦略を変更

    private Payment payment;

    public Customer() {
    }

    public void setPayment(Payment _payment) {
        payment = _payment;
    }

    public void purchase(int amount) {
        payment.make(amount);
    }

    public abstract void display();
}
