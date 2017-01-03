package observer;

public class Main {

    public static void main(String[] args) {

        // Create observerable object(Newsletter)
        // ニュースを更新し、そのことを購読者(Observer(subscribers))へ通知(Notify)する
        Newsletter newsletter = new Newsletter();

        // You probably will get the subscribers data from database
        // ニュースを購読する人たち
        // 最新ニュースがあったとき、その通知を受ける
        String subscribers[] = {"Mark", "Peter", "Alex"};


        // Then create subscriber object(s), and pass newsletter object.
	    // Each subscriber object will add itself to array of observers,
	    // for the passed newsletter object
        // SubscriberがObserverである
        Subscriber subscriber = null;

        for (String name : subscribers) {
            subscriber = new Subscriber(name, newsletter);
        }

        // Whenever you create a new newsletter,
        // Subscribers will get notified
        newsletter.create("This newsletter shall be sent to subscribers");

        // You can also delete a subscriber from array of observers
        newsletter.deleteObserver(subscriber);
    }

}
