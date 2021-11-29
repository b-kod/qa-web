package demo;

public class BookDemo {
    public static void main(String[] args) {
        Book favoriteBook = new Book();
        favoriteBook.setName("Harry Potter");
        favoriteBook.setAuthor("Joanne Rowling");
        favoriteBook.setGenre("Fantasy");
        favoriteBook.setVote(10);

        favoriteBook.printBookName();
        favoriteBook.printBookAuthor();
        favoriteBook.printBookGenre();
        favoriteBook.printBookVote();
    }
}
