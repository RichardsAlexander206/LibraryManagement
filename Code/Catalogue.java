import java.util.ArrayList;

public class Catalogue {
    //everything in class is static, never gets instansiated

    //collection never gets set to new object
    private final static ArrayList<Book> collection = new ArrayList<Book>();

    //Track current id index for books
    private static int currentID = 0;

    //set books
    //@return void @param Book book
    public static void addBook(Book book) {collection.add(book);}

    //get books

    //@return Book @param int id
    public static Book getBook(int id) {return collection.get(id);}

    //@overload
    //@return Book @param String name
    public static Book getBook(String name) {
        for (int i = 0; i < collection.size(); i++) {
            if(collection.get(i).getName().equals(name)) {
                return collection.get(i);
            }
        }
        return null;
    }

    //returns all books by author
    //@return String @param String author
    public static String getBooksByAuthor(String author) {
        String finalString = "";
        for(int i = 0; i < collection.size(); i++) {
            if(collection.get(i).getAuthor().equals(author)) finalString += collection.get(i).getName() + ", ";
        }
        if(finalString.equals("")) {
            return null;
        }
        return finalString.substring(0, finalString.length()-2);
    }

    //returns sorted list
    //@return String @param String type
    public static String sort(String type) {
        //bubble sort by name in alphebetical order
        Book temp;
        String finalReturn = "";
        if(type.equals("name")) {
            for(int i = 1; i < collection.size(); i++) {
                for(int z = 0; z < i; z++) {
                    if(collection.get(i).getName().compareTo(collection.get(z).getName()) < 0) {
                        temp = collection.get(z);
                        collection.set(z, collection.get(i));
                        collection.set(i, temp);
                    }
                }
            }
        }

        //references for lambda
        //https://www.w3schools.com/java/java_lambda.asp
        //https://www.youtube.com/watch?v=tj5sLSFjVj4&t=51s
        if(type.equals("author")) {
            collection.sort( (a, b) -> { return a.getAuthor().compareTo(b.getAuthor());}); 
        }


        //return sorted string
        for(int i = 0; i < collection.size(); i++) {
            finalReturn += "\n" + collection.get(i).getBookInfo() + "\n";
        }
        return finalReturn;
    }

    //increment book ID
    //@return int @param none
    public static int getNewId() {return currentID++;}
}