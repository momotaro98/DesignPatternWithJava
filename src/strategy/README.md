# Strategy

## Strategy パターン
どんなプログラムも、問題を解くために書かれている。そして問題を解くために特定のアルゴリズムが実装されている。Strategyパターンでは、そのアルゴリズムを実装した部分がごっそりと交換できるようになっている。アルゴリズム(戦略・作戦・方策)をカチッと切り替え、同じ問題を別の方法で解くのを容易にするパターン、それがStrategyパターンである。  

## サンプルプログラム
### `Customer` --> `GoldCustomer`, `SilverCustomer`
`Payment`という戦略を利用して支払いを行う  
`Payment`を実装した具象ストラテジーのインスタンスを委譲する

### `Payment` ..> `PayPal`, `CreditCard`
ストラテジーの実装

## Sample Code Running

```
$ cd src
$ javac strategy/Main.java
$ java strategy.Main
Hey! I am a SILVER Customer
You have successfully paid $5000 with paypal
Paypal Email: example@paypal.com
You have successfully paid $2500 with credit card
Your name: John
Your Card Number: 5824381
```

## Strategy パターンの登場人物
### Strategy(戦略)の役
戦略を利用するためのインターフェース(API)を定める役。サンプルプログラムでは、`Payment`インターフェースがこの役をつとめている。

### ConcreteStrategy(具体的戦略)の役
Strategy役のインターフェース(API)を実際に実装する役。ここで具体的な戦略(作戦・方策・方法・アルゴリズム)を実際にプログラミングする。サンプルプログラムでは、`PayPal`と`CreditCard`がこの役をつとめている。

### Contextの役
Strategy役を利用する役。ConcreteStrategy役のインスタンスを持っていて、必要に応じてそれを利用する(あくまで呼び出すのはStrategy役のインターフェース)。サンプルプログラムでは、`Customer`がこの役をつとめている。

## 考えを広げるためのヒント
### わざわざStrategy役を作る必要ってあるのか
普通にコーディングをしていると、メソッドの中に溶け込んだ形でアルゴリズムを実装してしまいがちである。しかし、Strategyパターンでは、アルゴリズムの部分を他の部分と意識的に分離する。そしてアルゴリズムとのインターフェースの部分だけを規定する。そして、プログラムから委譲によってアルゴリズムを利用する。  
Strategyパターンを使っていれば、Strategy役のインターフェースを変更しないように注意して、ConcreteStrategy役だけをいじればよい。しかも、 **委譲というゆるやかな結びつきを使っているので、アルゴリズムを容易に切り替えることができる** 例えば、元のアルゴリズムと改良したアルゴリズムの速度を比較したい場合でも、簡単に切り替えて試すことができる。  
Strategyパターンを使っていれば、将棋のゲームを行うプログラムで、ユーザの選択にあわせて思考ルーチンのレベルを切り替えることも簡単にできる。  

### 実行中に切り替えることも可能
Strategyパターンを使えば、プログラムの動作中にConcreteStrategy役を切り替えることもできる。例えば、メモリが少ない環境ではSlowButLessMemoryStrategy(速くはないが省メモリの戦略)を使い、メモリが多い環境ではFastButMoreMemoryStrategy(速いがメモリを食う戦略)を使うといったことも考えられる。  

## 関連しているパターン
### Flyweight パターン
ConcreteStrategy役は、Flyweightパターンを使って復習箇所から共有できる場合がある

### Abstract Factory パターン
Strategyパターンでは、アルゴリズムをごっそり切り替えることができる。  
Abstract Factory パターンでは、具体的な工場・部品・製品をごっそり切り替えることができる。

### State パターン
StrategyパターンもStateパターンも、ともに委譲先を切り替えるパターンであり、クラス間の関係もよく似ている。しかも、両方のパターンは目的が異なっている。  
Strategyパターンは、「アルゴリズム」を表現するクラスを作成し、それをConcreteStrategy役とする。Strategyパターンではクラスを切り替えることは可能であるが、必要がなければ切り替えなくてもかまわない。  
一方、Stateパターンでは、「状態」を表現するクラスを作成し、それをConcreteState役とする。Stateパターンでは状態が変化するたびに委譲先のクラスが必ず切り替わる。  
