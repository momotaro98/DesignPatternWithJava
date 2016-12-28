package bridge;

public class Blue implements Color {
    // 実装階層の具体

    @Override
    public void apply() {
        System.out.println("Blue");
    }
}
