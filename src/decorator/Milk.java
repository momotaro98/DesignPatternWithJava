package decorator;

public class Milk extends Decorator {
    // 具体的なデコレータクラス

    public Milk(MenuItem _beverage) {
        // デコレーションの対象であるbeverageインスタンスを取得
        super(_beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 7.4;
    }

    @Override
    public String description() {
        return beverage.description() + ", Milk";
    }

}
