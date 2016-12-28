package adapter.object;

public class Main {

    public static void main(String[] args) {

        // create animal instance & call run() method.
        Animal animal = new Dog();
        animal.run();

        // Kangarooはrunできないが、(例 jumpをする),
        // Kangarooオブジェクトを再利用するために
        // KangarooAdapterを間につなぐ
        // これにより、Dogオブジェクトと同様にrun()が使える
        animal = new KangarooAdapter();
        animal.run();
    }
}
