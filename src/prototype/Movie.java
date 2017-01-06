package prototype;

public class Movie implements Product{

    private String title;

    public Movie(String _title){
        title = _title;
    }

	@Override
	public Movie createClone() {
		try {
            // cloneメソッドはjavaオブジェクトの一番上の
            // java.lang.Objectが実装しているメソッドであり、
            // ここでは、Movie型を返すようにキャストする
			return (Movie) clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Movie Title: " + title;
	}

}
