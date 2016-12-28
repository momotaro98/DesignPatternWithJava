package bridge;

public class Rectangle extends AbstractShape {
    // 機能階層の具体

    public Rectangle(Color _op) {
        super(_op);
    }

    @Override
    public void applyColor() {
        System.out.println("Rectangle is now colored with ");
        this.color.apply();
    }
}
