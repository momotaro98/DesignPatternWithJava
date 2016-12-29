package composite;

public class Line implements Shape {
    // Shapeインターフェースを実装するクラス
    // Picture内で保持される

    @Override
    public void draw() {
        System.out.println("Line");
    }
}
