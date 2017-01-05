package factory.method;

public class Main {

    public static void main(String[] args) {

        AnimalFactory factory = new AnimalFactory();

        Animal cat = factory.create("cat");
        cat.voice();

        Animal dog = factory.create("Dog");
        dog.voice();
    }
}
