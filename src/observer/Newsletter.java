package observer;

import java.util.Observable;

public class Newsletter extends Observable {
    // 自身の内容を更新した際、
    // Observerに対して通知をする(Notify)
    // Observableとよばれる役割

    // NewsletterクラスはObservableクラスを継承している
    // Observableクラスは
    // * addObserverメソッド <= Observerを登録する処理 (Subscriberクラス側が実行する)
    // * setChanged()メソッド <= 変更点を整える処理
    // * notifyObserversメソッド <= 変更を登録したObserverへ通知する処理 (登録しているObserver達のupdateメソッドを実行する)
    // を実装している

    private String content;

    public Newsletter(){}

    public void notifyChanges() {
        setChanged();
        notifyObservers();
    }

    public void create(String _content) {
        content = _content;
        // contentを修正したら変更をObserver達へ通知する
        notifyChanges();
    }

    public String getContent() {
        return content;
    }
}
