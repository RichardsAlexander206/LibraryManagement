import java.util.ArrayList;
import java.util.Scanner;

class Client {
    //Client class for user to interact with. Interacts with other classes

    //
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<User>();
    static User Jimmy = new User("Jimmy", 111222333, "Coolplace Avenue");
    static User JimmyJr = new User("Jimmy Jr.", 222333444, "Coolplace Avenue");
    static Admin Billy = new Admin("Billy", 333444555, "Hogwarts");

    //main class to run off of
    //@return void @param String
    public static void main(String args[]) {
        
        //Array list for users
        users.add(Jimmy);
        users.add(JimmyJr);
        users.add(Billy);


        //add initial books to catalogue
        Catalogue.addBook(new Book("Harry Potter", "JK Rowling"));
        Catalogue.addBook(new Book("Throne of Glass", "Sarah J Mass"));
        Catalogue.addBook(new Book("Heir of Fire", "Sarah J Mass"));
        Catalogue.addBook(new Book("Dune", "Frank Herbert"));

        String response = "";
        while(true) {
            System.out.println("Welcome! Are you a member or admin? To leave please enter 'exit'");
            //member path
            response = scanner.nextLine();
            if(response.equals("member")) {
                while(true) {
                    System.out.println("\nWhich action would you like to complete?\n1) search for a title or author\n2) view sorted catalogue\n3) go back");
                    response = scanner.nextLine();

                    //Search for book
                    if(response.equals("1")) {
                        System.out.println("What is the name or author you would like to search for?");
                        response = scanner.nextLine();

                        if(Catalogue.getBook(response) != null) System.out.println("Book found: \n" + Catalogue.getBook(response).getBookInfo());
                        if(Catalogue.getBooksByAuthor(response) != null) System.out.println("Found books written by that author: " + Catalogue.getBooksByAuthor(response));
                    }

                    //View whole catalogue
                    else if(response.equals("2")) {
                        System.out.println("Would you like to sort by name or author?");
                        System.out.println(Catalogue.sort(scanner.nextLine()));
                    }

                    //Exit
                    else if(response.equals("3")) {
                        break;
                    }

                    //Input validation
                    else {
                        System.out.println("Invalid input");
                    }
                }
            }
            //admin path
            else if(response.equals("admin")) {

                //While true used to loop until user exits program
                while(true) {
                    System.out.println("Which action would you like to complete?\n 1) check out book\n 2) check in book\n 3) get loaned book \n 4) add book to catalogue \n 5) create new user account \n 6) change account information \n 7) go back");
                    response = scanner.nextLine();
                    //Loan out book
                    if(response.equals("1")) checkBook();

                    //Return book
                    else if(response.equals("2")) {
                        while(true){
                            System.out.println("What is the name of the book being returned?");
                            response = scanner.nextLine();
                            
                            if(Catalogue.getBook(response) != null) {
                                System.out.println(Billy.returnBook(Catalogue.getBook(response)));
                            }
                            else {
                                System.out.println("Invalid");
                            }
                            break;
                        }
                    }
                    //Get who loaned a book
                    else if(response.equals("3")) {
                        while(true){
                            System.out.println("What is the name of the book being tracked?");
                            response = scanner.nextLine();
                            
                            if(Catalogue.getBook(response) != null && Billy.getUserRentedTo(Catalogue.getBook(response)) != null) {
                                System.out.println("Book currently is loaned by account:\n" + Billy.getUserRentedTo(Catalogue.getBook(response)).getInfo());
                            }
                            else {
                                System.out.println("Invalid");
                            }
                            break;
                        }
                    }

                    //Add new book to catalogue
                    else if(response.equals("4")) {
                        System.out.println("What is the name of the book to be added?");
                        String name = scanner.nextLine();
                        System.out.println("What is the name of the author who wrote this book?");
                        String author = scanner.nextLine();
                        Catalogue.addBook(new Book(name, author));
                        System.out.println("Book " + name + " has been added");
                    }

                    //Create account
                    else if(response.equals("5")) {
                        System.out.println("What is the name of the account being created?");
                        String name = scanner.nextLine();
                        System.out.println("What is the phone number of the account being created?");
                        int phoneNumber = Integer.valueOf(scanner.nextLine());
                        System.out.println("What is the address of the account being created?");
                        String address = scanner.nextLine();
                        users.add(new User(name, phoneNumber, address));
                        System.out.println("New user created: " + users.get(users.size()-1).getInfo());


                    }

                    //Change account
                    else if(response.equals("6")) changeAccount();

                    else if(response.equals("7")) break;

                    //Input validation
                    else System.out.println("Invalid input");
                }
            }

            //Exit program
            else if(response.equals("exit")) {
                scanner.close();
                break;
            }
        }
    }

    //check out books by name
    //@return void @param none
    public static void checkBook() {
        System.out.println("What is the name of the book being loaned?");
        while(true) {
            String book = scanner.nextLine();
            if(Catalogue.getBook(book) != null) {
                System.out.println("What is the name of the account being loaned to?");
                while(true) {
                    String account = scanner.nextLine();
                    for(int i = 0; i < users.size(); i++) {
                        if(users.get(i).getName().equals(account)) {
                            System.out.println(Billy.rentBook(users.get(i), Catalogue.getBook(book)));
                            return;
                        }
                    }
                        System.out.println("Invalid");
                }
            }
            else System.out.println("Invalid");
        }   
    }

    //change account information
    //@return void @param none
    public static void changeAccount() {
        while(true) {
            System.out.println("What is the id of the account you would like to change?");
            int id = Integer.valueOf(scanner.nextLine());
            System.out.println("What field would you like to change? \n 1) name \n 2) phone number \n 3) address \n 4) go back");
            String field = scanner.nextLine();
            System.out.println("What would you like to change it to?");
            String change = scanner.nextLine();

            if(field.equals("1")) {
                for(int i = 0; i < users.size(); i++) {
                    if(users.get(i).getId() == id) {
                        users.get(i).setName(change);
                        return;
                    }
                }
                System.out.println("invalid id");
            }

            else if(field.equals("2")) {
                for(int i = 0; i < users.size(); i++) {
                    if(users.get(i).getId() == id) {
                        users.get(i).setPhoneNumber(Integer.valueOf(change));
                        return;
                    }
                }
                System.out.println("invalid id");
            }

            else if(field.equals("3")) {
                for(int i = 0; i < users.size(); i++) {
                    if(users.get(i).getId() == id) {
                        users.get(i).setAddress(change);
                        return;
                    }
                }
                System.out.println("invalid id");
            }

            else if(field.equals("4")) return;

            else System.out.println("Invalid output");
        }
    }
}