package singleton;

public class Database {

    // この初期化はクラスのロード時に一度だけ行われる
    private static Database database = new Database();

    // Singletonクラスのコンストラクタはprivate
    private Database(){}

    // 外部はこのgetInstanceメソッドから唯一のインスタンスを取得する
    public static Database getInstance(){
        return database;
    }

    public void display(){
        System.out.println("I'm the Static Singleton");
    }
}
