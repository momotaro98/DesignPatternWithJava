package iterator;

import java.util.Iterator;


public class Main {

    public static void main(String[] args) {

        // create list object(list of strings)
        MyList list = new MyList();

        // add strings
        list.addItem("Prague");
        list.addItem("California");
        list.addItem("Amsterdam");

        // get iterator object
        // JavaのビルドインであるIteratorインターフェース型で
        Iterator<String> it = list.iterator();

        // iterate through list items
        // MainはMyList内の実装が変わったとしても
        // 常に下記の記述の書き方で要素を取り出せる
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

}
