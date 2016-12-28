package decorator;

public class Mocha extends Decorator {
    // 具体的なデコレータクラス

    public Mocha(MenuItem _beverage) {
        // デコレーションの対象であるbeverageインスタンスを取得
        super(_beverage);
    }

    @Override
    public double cost() {
        return beverage.cost() + 5.0;
    }

    @Override
    public String description() {
        return beverage.description() + ", Mocha";
    }

}
