interface UserInterface {
    //Interface for User
    
    //@return String @param none
    String getName();

    //@return int @param none
    int getPhoneNumber();

    //@return Stinrg @param none
    String getAddress();

    //@return int @param none
    int getId();

    //@return Book @param none
    Book getBookRented();

    //@return String @param none
    String getInfo();

    //@return void @ param Book book
    void setBookRented(Book book);
}
