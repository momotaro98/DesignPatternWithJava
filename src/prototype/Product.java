package prototype;

public interface Product extends Cloneable{
    // Productインターフェースは、Cloneableインターフェースを継承する
    // Cloneableインターフェース自体にはメソッドは定義されておらず、
    // cloneメソッドを実行できる実クラスであるかを判断するための
    // マーカーインタフェースである

	public Product createClone();

}
