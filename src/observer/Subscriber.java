package observer;

import java.util.Observable;
import java.util.Observer;

public class Subscriber implements Observer{

    private String name;

    public Subscriber(String _name, Observable observerable){
        name = _name;
        // ↓キーポイント: Observerを生成するとき対象のobserverableを委譲し
        // addObserverメソッドでObserver自身(this)を通知してもらえるように
        // observerableのobserversへ追加する
        observerable.addObserver(this);
    }

    // Observerインターフェースのupdateを実装
    @Override
    public void update(Observable observerable, Object arg) {
        if(observerable instanceof Newsletter){
            System.out.println("Subscriber " + name + " was notified " + observerable);
        }
    }
}
