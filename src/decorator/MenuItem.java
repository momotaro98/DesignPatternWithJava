package decorator;

public interface MenuItem {
    // Mainが利用するAPIがこのMenuItemインターフェースである

    // 合計料金を返す
    public double cost();

    // 説明文を返す
    public String description();

}
