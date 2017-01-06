package prototype;

public class Book implements Product{

    private String title;

    public Book(String _title){
        title = _title;
    }

	@Override
	public Book createClone() {
		try {
            // cloneメソッドはjavaオブジェクトの一番上の
            // java.lang.Objectが実装しているメソッドであり、
            // ここでは、Book型を返すようにキャストする
			return (Book) clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Book Title: " + title;
	}

}
