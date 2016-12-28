package decorator;

public class Main {

    public static void main(String[] args) {

        // // Order hot chocolate
        // MenuItem beverage = new HotChocolate();
        // // add milk
        // beverage = new Milk(beverage);
        // // add mocha flavor to it
        // beverage = new Mocha(beverage);

        // 上記を下記のように1文で書く

        MenuItem beverage =
                    new Mocha( // さらにモカを追加 ($20.5 + $7.4 + $5.0 = $32.9)
                        new Milk(  // ミルクを追加 ($20.5 + $7.4)
                            new HotChocolate() // デコレーションされる真の中身であるホットチョコレート($20.5)
                        )
                    );

        // get invoice
        System.out.println("Your Order: " + beverage.description());
        System.out.println("Total Cost: " + beverage.cost());

    }
}
