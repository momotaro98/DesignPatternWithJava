# Observer

## Observer パターン
Observerパターンでは、観察対象の状態が変化すると、観察者に対して通知される。  

Observerパターンは、状態変化に応じた処理を記述するときに有効である。

## Sample Code Running

```
$ cd src
$ javac observer/Main.java
$ java observer.Main
Subscriber Alex was notified observer.Newsletter@15db9742
Subscriber Peter was notified observer.Newsletter@15db9742
Subscriber Mark was notified observer.Newsletter@15db9742
```

## Observer パターンの登場人物
### Subject(Observable)(被験者)の役
Subject(Observable)役は、「観察される側」を表す。Subject役は、観察者であるObserver役を登録するメソッドと、削除するメソッドを持っている。また、「現在の状態を取得する」メソッドも宣言されている。  
サンプルプログラムでは、`Newsletter`が役割をつとめている。  

### Observerの役
Observer役は、Subject(Observable)役から「状態が変化した」と教えてもらう役である。そのためのメソッドがupdateメソッドであり、Subject(Observable)側で登録されているObserverのupdateメソッドを実行する。  
サンプルプログラムでは、`Subscriber`がその役割をつとめている。

## 考えを広げるためのヒント
### 「観察」よりも「通知」である
observerという言葉の本来の意味は「観察者」ですが、実際にはObserver役は能動的に「観察」するのではなく、Subject(Observable)役から「通知」されるのを受動的に待っていることになる。Observerパターンは、 **Publish-Subscribe** パターンと呼ばれることもある。publish(発行)とsubscribe(購読)という表現の方が、実態にあっている。

## 補講: `java.util.Observer`インターフェース
Javaのクラスライブラリに登場する`java.util.Observer`インターフェースと`java.util.Observable`クラスは、Observerパターンの一種である。  
`java.util.Observer`インターフェースは、以下のメソッドを持っている。  

```
public void update(Observable obj, Object arg)
```

`update`メソッドでは、引数に
* 観察される側(Subject役)として、Observableクラスのインスタンス
* 付加情報として、Objectクラスのインスタンス

が与えられている。  
「なんだ、JavaにはちゃんとObserverパターンがあるのか、じゃあ、これを使うようにしよう」と思ってしまうかもれしれない。  
しかし、`java.util.Observer`インターフェースと`java.util.Observable`クラスはあまり使いやすくない。理由は単純で、`java.util.Observer`インターフェースで渡すSubject役には、`java.util.Observable` **クラス** (またはそのサブクラス)を使う必要があるためである。Javaのクラスは単一継承である。Subject役にしようと思っているクラス(つまり観察対象とするクラス)がすでに何かのサブクラスになっていた場合には、`java.util.Observable`クラスのサブクラスにすることはできない。  
[Coad本](https://www.amazon.com/Java-Design-Building-Better-Applets/dp/0139111816)では、この問題を取り上げている。そこでは、Subject役もObserver役もJavaのインターフェースとして実現して、より扱いやすいObserverパターンが紹介されている。

## 関連しているパターン
### Mediatorパターン
Mediatorパターンでは、Mediator役とColleague役の通信にObserverパターンを使う場合がある。  
MediatorパターンとObserverターンは、どちらも「状態変化を通知する」という点では似ている。しかし、パターンの目的や視点は異なる。  
Mediatorパターンでも、状態変化が通知される。しかし、それはColleague役の調停という目的で動いているMediatorパターンの一部にすぎない。  
Observerパターンでは、Subject役の状態変化をObserver役(複数かもしれない)に通知すること、通知して同期をとることに主眼がある。
