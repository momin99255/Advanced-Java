package SRP;

public class Book {
    private String title;
    private String author;
    private int bookId;

    public Book(String title, String author, int bookId) {
        this.title = title;
        this.author = author;
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getBookId() {
        return bookId;
    }


    //methods
    public void printBook(){
        IO.println(title +" "+ author + " " + bookId);
    }

//    public void storeBookToDatabase(){
//        IO.println("SRP.Book Stored in Database");
//    }
}
// If database logic changed whole book class will need to be changed
//srp fixed by commenting and separating classes
