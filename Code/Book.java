
public class Book {
    //holds information on given book

    //fields final because book authors and names don't ever change
    private final String name;
    private final String author;
    private final int id;
    
    //rentedTo does change
    private User rentedTo;

    //create new book with generated ID
    public Book(String name, String author) {
        //@param name, author
        this.name = name;
        this.author = author;

        //id automatically generated
        id = Catalogue.getNewId();
        rentedTo = null;
    }

    //getters
    //@return String @param none
    public String getName() {return name;}

    //@return String @param none
    public String getAuthor() {return author;}

    //@return int @param none
    public int getID() {return id;}

    //returns all book information in a String
    //@return String @param none
    public String getBookInfo() {return "Name: " + getName() + "\nAuthor: " + getAuthor() + "\nID: " + getID();}

    //@return User @param none
    public User getRentedTo() {return rentedTo;}

    //@return void @param User user
    public void setRentedTo(User user) {rentedTo = user;}

}
