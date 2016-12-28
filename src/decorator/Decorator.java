package decorator;

public class Decorator implements MenuItem {

    // beverageはMenuItemインターフェース実装のインスタンスであり、
    // 継承クラスも参照できるDecoratorクラスのインスタンス変数である
    // いわゆる「委譲」である
    // デコレータの中身であるMenuItems実装のクラスを委譲することでデコレーションを実現する
    protected MenuItem beverage;

    public Decorator(MenuItem _beverage) {
        beverage = _beverage;
    }

    @Override
    public double cost() {
        // beverageインスタンスを使うことでcost()を実装
        return beverage.cost();
    }

    @Override
    public String description() {
        return beverage.description();
    }
}
