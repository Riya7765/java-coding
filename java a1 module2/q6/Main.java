import java.util.Scanner;

class Author {
    private String name;
    private String email;
    private String gender;

    public Author(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author Name: " + name +
               "\nEmail: " + email +
               "\nGender: " + gender;
    }
}

class Book {
    private String title;
    private double price;
    private Author author;

    public Book(String title, double price, Author author) {
        this.title = title;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book Title: " + title +
               "\nPrice: " + price +
               "\n" + author;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String title = sc.nextLine().trim();
        double price = Double.parseDouble(sc.nextLine().trim());

        String[] parts = sc.nextLine().split(",");

        String name = parts[0].trim();
        String email = parts[1].trim();
        String gender = parts[2].trim();

        Author author = new Author(name, email, gender);
        Book book = new Book(title, price, author);

        System.out.println(book);

        sc.close();
    }
}