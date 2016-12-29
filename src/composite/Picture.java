package composite;

import java.util.List;
import java.util.ArrayList;

public class Picture implements Shape {
    // Shapeインターフェースというエントリの実装
    // Pictureは[Circle, Line, Rectangle](葉), Picture(節)といった、
    // Shapeインターフェース実装された
    // どのインスタンスも内部フィールドのshapesで管理する

    private List<Shape> shapes = new ArrayList<Shape>();
    private String name;

    public Picture(String _name) {
        name = _name;
    }

    @Override
    public void draw() {
        System.out.println("Start Drawing Picture: " + name);
        for (Shape shape: shapes) {
            shape.draw();
        }
        System.out.println("Finished Drawing Picture: " + name);
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    public void remove(Shape shape) {
        shapes.remove(shape);
    }
}
