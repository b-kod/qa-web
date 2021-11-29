package demo;

public class Book {
    private String name;
    private String author;
    private String genre;
    private int vote;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name !="") {
            this.name = name;
        } else {
            System.out.println("Please enter the name of the book");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author !="") {
            this.author = author;
        } else {
            System.out.println("Please enter the author of the book");
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre !="") {
            this.author = genre;
        } else {
            System.out.println("Please enter the genre of the book");
        }
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        if (vote >= 1) {
            this.vote = vote;
        } else {
            System.out.println("Your vote cannot be 0. Choose from 0 to 10");
        }
    }

    public void printBookName() {
        System.out.println("The book's name is: " + name);
    }

    public void printBookAuthor() {
        System.out.println("Written by " + author);
    }

    public void printBookGenre() {
        System.out.println("Genre: " + genre);
    }

    public void printBookVote() {
        System.out.println("Your vote: " + vote);
    }

}
