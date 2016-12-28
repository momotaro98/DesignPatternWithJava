package bridge;

public class Main {

    public static void main(String[] args) {

        // 実行時において互いに独立に変化する場合は、
        // RectangleクラスとCircleクラスを
        // Color実装から分離することが望ましい

        // MainはRectangleという"機能"を持った層を利用
        // RectangleはBlueという"実装"を持った層を利用することで機能を実現
        AbstractShape shape = new Rectangle(new Blue());
        shape.applyColor();

        shape = new Circle(new Red());
        shape.applyColor();

    }
}
