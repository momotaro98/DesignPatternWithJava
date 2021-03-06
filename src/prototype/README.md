# Prototype
## Prototype パターン
newでインスタンスを生成する場合には、クラス名を必ず指定しなければならない。しかし、クラス名を指定せずにインスタンスを生成したい場合もある。クラスからインスタンスを生成するのではなく、インスタンスをコピー(複製)して新しいインスタンスを作る。それは以下のような場合である。

### (1) 種類が多すぎてクラスにまとめられない場合
1つ目は、扱うオブジェクトの種類があまりにも多すぎて、1つ1つを別のクラスにしていたら、ソースファイルを多数作成する必要が生じてしまう場合。

### (2) クラスからのインスタンス生成が難しい場合
2つ目は、生成させたいインスタンスが複雑な過程を経て作られるものであり、クラスから作り上げることが困難な場合。例えば、グラフィックエディタなどでユーザがマウスの操作によって作り上げた図形を表すインスタンスなどである。

### (3) フレームワークと生成するインスタンスを分けたい場合
3つ目は、インスタンスを生成するときのフレームワークを、特定のクラスに依存しないように作りたい場合。このような場合は、クラス名を指定するのではなく、前もって「ひな形」となるインスタンスを登録しておき、その登録したインスタンスをコピーすることでインスタンスを生成する。  

インスタンスから別のインスタンスを作り出すということは、コピー機を使って書類をコピーすることに似ている。下の書類をどうやって作ったかを知らなくても、コピー機にかければ同じ書類を何枚でも作れる。  

## Sample Code Running

```
$ cd src
$ javac prototype/Main.java
$ java prototype.Main
Album Title: Pleasure
Book Title: Le Petit Prince
Movie Title: God Father
```

## Prototype パターンの登場人物
### Prototype(原型)の役
Prototype役は、インスタンスをコピーして新しいインスタンスを作るためのメソッドを定める。サンプルプログラムでは、`Product`インターフェースがこの役をつとめている。

### ConcretePrototype(具体的な原型)の役
ConcretePrototype役は、インスタンスをコピーして新しいインスタンスを作るメソッドを実際に実装する。サンプルプログラムでは、`Movie`, `Book`, 'Album'がこの役をつとめている。

### Client(利用者)の役
Client役は、インスタンスをコピーするメソッドを利用して、新しいインスタンスを作る。サンプルプログラムでは、`ProductFactory`がこの役をつとめている。

## 考えを広げるためのヒント
### クラス名は束縛なのか
ソースプログラムの中にクラス名が書かれていると、何が問題なのか。
オブジェクト指向プログラミングの目標の1つ「部品としての再利用」がある。ソースの中に利用するクラスの名前を書いておくことが、常に悪いわけではないが、 **ソースの中に利用するクラスの名前が書かれていると、そのクラスと切り離して再利用することはできなくなってしまう** 。  

## 関連しているパターン
### Flyweightパターン
Prototypeパターンでは、現在のインスタンスと同じ状態の別のインスタンスを作って利用する。  
Flyweightパターンでは、1つのインスタンスを複数の場所で共有して利用する。
### Mementoパターン
Prototypeパターンでは、現在のインスタンスと同じ状態の別のインスタンスを作る。  
Mementoパターンでは、スナップショットとアンドゥを行うために現在のインスタンスの状態を保存する。

## 補講 : cloneメソッドとjava.lang.Cloneableインターフェース
### Java言語のclone
Java言語では、インスタンスのコピーを行う機構として`clone`メソッドが用意されている。`clone`メソッドを実行する場合、 **コピー対象となるクラスはjava.lang.Cloneablインターフェースを実装する必要がある** ことに注意。コピー対象となるクラスが直接`java.lang.Cloneable`インターフェースを実装してもかまわないし、スーパークラスのどこからで`Cloneable`インターフェースを実装していてもかまわない。  
`Cloneable`インターフェースを実装したクラスのインスタンスは、`clone`メソッドを呼び出すとコピーされる。そして、`clone`メソッドの戻り値はコピーによって作られたインスタンスになる。(内部で行っているのは、元のインスタンスと同じ大きさのメモリを確保し、元のインスタンスのフィールドの内容をコピーしている)。  
もしも、`Cloneable`インターフェースを実装していないクラスのインスタンスがcloneメソッドを呼び出すと、例外`CloneNotSupportedException`が発生する。  
なお、`java.lang.Object`パッケージは暗黙でimportされている。  

### `clone`メソッドはどこで定義されているか
`clone`メソッドは、`java.lang.Object`クラスで定義されている。`Object`クラスはJavaクラスのおおもとのクラスであるため、どのクラスでも`clone`メソッドを継承していることになる。  

### `Cloneable`が要求するメソッドは？
「`Cloneable`インターフェース」というと、その中に`clone`メソッドが宣言されているように考えがちだが、違う。`Cloneable`インターフェースにはメソッドは1つも宣言されていない。このインターフェースは単に「cloneによってコピーすることができる」という印としてつかわれている。このような印を付けるインターフェースのことを **マーカーインタフェース(marker interface)** と呼ぶ。
