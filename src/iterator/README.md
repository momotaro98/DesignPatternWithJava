# Iterator

## Iterator パターン
Java言語で配列arrの要素をすべて表示するには、for文を使って次のように書く。

```
for (int i =0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

ここで使われている変数iの働きを抽象化し、一般化したものを、デザインパターンでは、 **Iterator** パターンと呼んでいる。  
Iteratorパターンとは、何かがたくさん集まっているときに、それを順番に指し示していき、全体をスキャンしていく処理を行うためのもの。  


## Sample Code Running

```
$ cd src
$ javac iterator/Main.java
$ javac iterator/ListIterator.java
$ java iterator.Main
Prague
California
Amsterdam
```

## Iterator パターンの登場人物
### Iterator(反復子)の役
要素を順番にスキャンしていく役。サンプルプログラムでは、`ListIterator`がこの役をつとめ、次の要素が存在するかどうかを得るための`hasNext`メソッドと、次の要素を得るための`next`メソッドを定めている。  

### Aggrerate(集合体)の役
Iterator役を作り出す役。サンプルプログラムでは、`MyList`がこの役をつとめ、`iterator`メソッドを実装していた。

## 考えを広げるためのヒント
### 実装がどうであれ、Iteratorを使える
どうしてIteratorパターンなんて面倒なものを考える必要があるのか。なぜ集合体の外にIterator役などというものを作る必要があるのか。  
大きな理由は、Iteratorを使うことで、実装とは切り離して、数え上げを行うことができるためである。  

```
while(it.hasNext()){
    System.out.println(it.next());
}
```

ここで使われているのは、`hasNext`メソッドと`next`というIteratorのメソッドだけである。 **上記のwhileループは、Aggrerate役の実装には依存しない** ことになる。  
`hasNext`と`next`メソッドが正しく実装されているクラスのインスタンスを返していれば、上記のwhileループはまったく **変更しなくても動作する** 。  

デザインパターンは、クラスの再利用化を促進するものである。再利用化を促進するとは、クラスを部品として使えるようにするということであり、1つのぶひんを修正しても、他の部品の修正が少なくてすむ、ということである。

### AggrerateとIteratorの対応
Aggrerate役での実装ががらりと変わったとき、Iterator役側も修正が必要となる。  
AggrerateとIteratorは対の関係になっている。

### 複数のIterator「数え上げの仕組みがAggrerate役の外に置かれている」というのは、Iteratorパターンの特徴の1つである。この特徴によって、1つのConcreteAggregate役に対して複数のConcreteIterator役を作ることができる。

### イテレータの種類いろいろ
サンプルプログラムでのIteratorは順方向に一度だけスキャンする単純なものであるが、スキャンには色々なバリエーションがある。

* 最後尾から開始して逆方向に進む
* 順方向にも逆方向にも行く(nextメソッドだけでなくpreviousメソッドも持つ)
* 番号を指定して、いきなりそこにジャンプする

このようなIteratorクラスも作ることができる  

### deleteIteratorメソッドは不要
Javaでは、使われなくなったインスタンスは自動的に削除される(ガベージコレクション)。そのため、iteratorに対応したdeleteIteratorメソッドは不要である。

## 関連しているパターン
### Visitorパターン
Iteratorパターンは、集合体から1つずつ要素を取り出して、数え上げていくもの。  
数え上げるのは、要素に対して何らかの処理を行うためであるが、Iteratorインターフェースの中にはその処理までは記述されていない。  

Visitorパターンは、たくさんの要素が集まっている中を渡り歩きながら、同じ処理を繰り返し繰り返し適用していくというもの。  

### Compositeパターン
Compositeパターンは再帰的な構造を持ったパターン。これにIteratorパターンを適用するのは難しい。

### Factory Methodパターン
IteratorメソッドがIteratorのインスタンスを作成するときに、Factory Methodパターンが使われる場合がある。
