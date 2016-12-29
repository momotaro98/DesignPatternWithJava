# Decorator

## Decoratorパターン
中心となるオブジェクトがあり、それに飾り付けとなる機能を一皮一皮かぶせていって、より目的にあったオブジェクトに仕上げていく。  
このような、オブジェクトにどんどんデコレーションをほどこしていくようなデザインパターンを  
**Decoratorパターン**  
とよぶ。

## サンプルプログラム

#### `MenuItem`
`Main`が利用するAPI

#### `HotChocolate` & `Espresso`:
デコレータの装飾対象である*中身*のオブジェクト

#### `Decorator`
`MenuItem`インターフェースを実装するクラスであり、具体的デコレータ用の抽象クラスでもある

#### `Milk` & 'Mocha'
具体的なデコレータクラス  
`HotChocolate`, `Espresso`という中身のインスタンスを委譲することで、装飾を行う

### Sample Running

```
$ cd src
$ javac decorator/Main.java
$ java decorator.Main
Your Order: Hot Chocolate, Milk, Mocha
Total Cost: 32.9
```

## Decoratorパターンの登場人物
#### Componentの役
機能を追加するときの核となる役。Component役は核におけるインターフェース(API)だけを定める。サンプルプログラムでは`MenuItem`がこの役をつとめている

#### ConcreteComponentの役
Component役のインターフェースを実装している具体的な中身。サンプルプログラムでは、`HotChocolate`, `Espresso`がこの役をつとめている

#### Decorator(装飾者)の役
Component役と同じインターフェースを持つ。そしてさらに、このDecorator役が飾る対象となるComponent役をもっている。この役は、自分が飾っている対象を委譲という形で「知っている」。サンプルプログラムでは、`Decorator`がこの役をつとめている

#### ConcreteDecorator(具体的な装飾者)の役
具体的なDecoratorの役。サンプルプログラムでは、`Milk`と`Mocha`がこの役をつとめている


## 考えを広げるためのヒント
### 透過的なインターフェース(API)
飾り枠をたくさん使って包んでも、インターフェースはまったく変更されない。これをインターフェースが「透過的(Transparent)」であるという。

### 中身を変えずに、機能追加できる
Decoratorパターンでは、包まれるものを変更することなく、機能の追加を行うことができる。  
Decoratorパターンでは、委譲が使われている。「飾り枠」に対してやってきた要求(メソッドの呼び出し)は、その「中身」にたらい回し(委譲)される。

### 動的な機能追加ができる
Decoratorパターンで使われている委譲は、クラス間をゆるやかに結合している。そのため、フレームワークのソースを変更することなく、オブジェクトの関係を変えた新しいオブジェクトを作ることができる。

### 単純な品揃えでも、多様な機能追加ができる
Decoratorパターンを使うと、多様な機能追加を行うことができる。具体的な飾り枠(ConcreteDecorator)をたくさん用意しておけば、それらを自由に組み合わせて新しいオブジェクトを作ることができる。

### java.ioパッケージとDecoratorパターン
java.ioというパッケージに含まれているクラスの話。

```
Reader reader = new LineNumberReader(
                    new BufferedReader(
                        new FileReader("datafile.txt")
                    )
                );
```

このように、Decoratorパターンが使われている。

### (デメリット)小さいクラスが増えてしまう
Decoratorパターンを使うと、よく似ている小さなクラスがたくさん作られてしまうという欠点もある。

## 関連しているパターン
#### Adapterパターン
Decoratorパターンは、中身のインターフェースを変えずに外枠をつくる(透過的)  
Adapterパターンは、ずれがある2つのインターフェースをつなぐために用いる

#### Strategy パターン
Decoratorパターンは、外枠を取り替えたり、外枠を重ねたりして機能を追加する。  
Strategyパターンは、アルゴリズムを切り替えて機能を変更する。
