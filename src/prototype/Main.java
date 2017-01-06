package prototype;

public class Main {

    public static void main(String[] args){
        // ProductFactory has references
		// to initially created objects(album, book, movie)
        Album album = new Album("Pleasure");
        Book book = new Book("Le Petit Prince");
        Movie movie = new Movie("God Father");
		ProductFactory factory = new ProductFactory(album, book, movie);

		// clone existing objects
		Album copied_album = factory.getAlbum();
		Book copied_book = factory.getBook();
		Movie copied_movie = factory.getMovie();

		System.out.println(copied_album);
		System.out.println(copied_book);
		System.out.println(copied_movie);

    }
}
