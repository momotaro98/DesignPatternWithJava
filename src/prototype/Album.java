package prototype;

public class Album implements Product{

    private String title;

    public Album(String _title){
        title = _title;
    }

	@Override
	public Album createClone() {
		try {
            // cloneメソッドはjavaオブジェクトの一番上の
            // java.lang.Objectが実装しているメソッドであり、
            // ここでは、Album型を返すようにキャストする
			return (Album) clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Album Title: " + title;
	}

}
