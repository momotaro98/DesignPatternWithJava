package composite;

public class Rectangle implements Shape {
    // Shapeインターフェースを実装するクラス
    // Picture内で保持される

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}
