package bridge;

public class Red implements Color {
    // 実装階層の具体


    @Override
    public void apply() {
        System.out.println("Red");
    }
}
