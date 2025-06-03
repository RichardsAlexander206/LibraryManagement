class Admin extends User{
    //Extension of user. Performs book keeping actions such as adding new books to catalogue and renting/checking books

    //reference for getting constructor from base class
    //https://www.geeksforgeeks.org/inheritance-and-constructors-in-java/
    public Admin(String name, int phoneNumber, String address) {
        //@param String name, int phoneNumber, String address
        super(name, phoneNumber, address);
    }

    //@return String @param User member Book book
    public String rentBook(User member, Book book) {
        if(book.getRentedTo() == null && member.getBookRented() == null) {
            member.setBookRented(book);
            book.setRentedTo(member);
            return book.getName() + " has been rented to " + member.getName() + ".";
        }
        else {
            return "Book or member is not currently eligible.";
        }
    }

    //@return String @param Book book
    public String returnBook(Book book) {
        if(book.getRentedTo() != null) {
            book.getRentedTo().setBookRented(null);
            book.setRentedTo(null);
            return book.getName() + " has been returned.";
        }
        else {
            return "Book cannot be returned.";
        }
    }

    //@return User @param Book book
    public User getUserRentedTo(Book book) {
        if(book.getRentedTo() != null) {
            return book.getRentedTo();
        }
        else {
            return null;
        }
    }
    

}