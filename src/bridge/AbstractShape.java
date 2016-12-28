package bridge;

public abstract class AbstractShape {
    // 機能階層の親
    // Colorという実装を委譲して機能とする

    // 継承したクラスも参照できるクラスフィールド
    protected Color color;

    public AbstractShape(Color _color) {
        color = _color;
    }

    public void setColor(Color _color) {
        color = _color;
    }

    public abstract void applyColor();
}
