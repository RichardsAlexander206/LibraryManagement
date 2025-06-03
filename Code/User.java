public class User implements UserInterface{
    //User class holds information on given user to track books
    private String name;
    private int phoneNumber;
    private String address;
    private int idIndex = 0;
    private Book bookRented;
    
    //account id never changes
    private final int id;

    //contructer
    public User(String name, int phoneNumber, String address) {
        //@param String name, int phoneNumber, String address
        //id is automatically generated
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        id = idIndex;
        idIndex++;
        bookRented = null;
    }

    //getters
    //@return String @param none
    public String getName() {return name;}

    //@return int @param none
    public int getPhoneNumber() {return phoneNumber;}

    //@return String @param none
    public String getAddress() {return address;}

    //@return int @param none
    public int getId() {return id;}

    //@return Book @param none
    public Book getBookRented() {return bookRented;}


    //converts contact information to String
    //@return String @param none
    public String getInfo() {
        return "name: " + name + " phone number: " + phoneNumber + " address: " + address + " id: " + id;
    }
    
    //setters
    //@return void @param String name
    public void setName(String name) {this.name = name;}

    //@return void @param int phoneNumber
    public void setPhoneNumber(int phoneNumber) {this.phoneNumber = phoneNumber;}

    //@return void @param String address
    public void setAddress(String address) {this.address = address;}

    //@return void @param Book book
    public void setBookRented(Book book) {bookRented = book;}

}