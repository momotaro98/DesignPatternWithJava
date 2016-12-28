package bridge;

public class Circle extends AbstractShape {
    // 機能階層の具体

    public Circle(Color _op) {
        super(_op);
    }

    @Override
    public void applyColor() {
        System.out.println("Circle is now colored with ");
        this.color.apply();
    }
}
