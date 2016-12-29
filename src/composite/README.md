# Composite

## Compositeパターン
容器の中には、中身を入れても良いし、さらに小さな容器を入れることもできる。そして、その小さな容器の中にもっと小さな容器を入れて・・・こんな風にして、入れ子になった構造、再帰的な構造を作ることができる。  

この章で学ぶ、Compositeパターンは、このような構造を作るためのものである。 **容器と中身を同一視し、再帰的な構造を作る** デザインパターン、それがCompositeパターンである。

## サンプルプログラム
### `Shape`
`Picture`と`[Circle, Line, Rectangle]`を同一視するインターフェース

### `Picture`
`Picture`自身も含む、Shape型のインスタンスを保持できる *節*

### `Circle`, `Line`, `Rectangle`
 *葉*

## Sample Code Running

```
$ cd src
$ javac composite/Main.java
$ java composite.Main
Start Drawing Picture: zoo
Circle
Line
Start Drawing Picture: lion
Rectangle
Line
Finished Drawing Picture: lion
Finished Drawing Picture: zoo
```

## Composite パターンの登場人物
### Leaf(葉)の役
「中身」を表す役。この役の中には他のものを入れることは出来ない。サンプルプログラムでは、`Circle`, `Line`, `Rectangle`がこの役をつとめている。  

### Composite(集合体)の役
「容器」を表す役。Leaf役やComposite役を入れることが出来る。サンプルプログラムでは、`Picture`がこの役をつとめている。

### Componentの役
Leaf役とComposite役を同一視するための役。Component役は、Leaf役とComposite役に共通のインターフェースとしてある。サンプルプログラムでは、`Shape`がこの役をつとめている。  

### Client(依頼者)の役
Mainクラスがこの役をつとめている。

## 考えを広げるためのヒント
### 複数と単数の同一視
Compositeパターンは容器と中身の同一視を行うパターンであるが、これを **複数と単数の同一視** と呼ぶことも出来る。すなわち、複数個のものを集めて、それをあたかも1つのものであるかのように取り扱う。  

### 再帰的構造はあらゆる場面で登場する
再帰的な構造およCompositeパターンは様々な場面で登場する。例えば、 *ウィンドウシステム* ではウィンドウの中に子ウィンドウを持たせるが、それはCompositeパターンの典型である。文章の *箇条書き* の各項目の中にさらに箇条書きが含まれるのも、再帰的な構造といえる。一般に、木構造になるデータ構造はCompositeパターンに当てはまる。

## 関連しているパターン
### Commandパターン
Commandパターンで「マクロコマンド」を作るときに、Compositeパターンが使われる。

### Visitorパターン
Visitorパターンは、Compositeをめぐりながら処理をするのに使う。

### Decoratorパターン
Compositeパターンは、容器(Composite役)と中身(Leaf役)をComponent役として同一視する。  
Decoratorパターンは、飾り枠と中身を同一視する。
