import crudOps.BookCrud;
import model.Book;
import model.Topic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        String jdbcUrl = System.getenv("url");
        String user = System.getenv("user");
        String password = System.getenv("password");

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("connexion reussie");
            BookCrud bookCrud = new BookCrud(connection);
            //bookCrud.delete(4);
            bookCrud.findAll();

            //pour tester la methode save
           /* Topic topic = new Topic();
            topic.setTopic_name("OTHER");


            Book bookToSave = new Book();
            bookToSave.setId_book(4);
            bookToSave.setTitle("Harry Potter");
            bookToSave.setTopic(topic);
            bookToSave.setId_author(1);


            Book savedBook = bookCrud.save(bookToSave);

            System.out.println("Livre sauvegardé avec succès:");
            System.out.println("ID du livre: " + savedBook.getId_book());
            System.out.println("Titre du livre: " + savedBook.getTitle());
            System.out.println("Topic du livre: " + savedBook.getTopic().getTopic_name());
            System.out.println("ID de l'auteur: " + savedBook.getId_author());


            */
            //pour tester la methode saveAll

           /* List<Book> booksToSave = new ArrayList<>();
            booksToSave.add(new Book(5, "Le Seigneur des Anneaux", new Topic("OTHER"), 2));
            booksToSave.add(new Book(6, "Da Vinci Code", new Topic("ROMANCE"), 3));

            List<Book> savedBooks = bookCrud.saveAll(booksToSave);

            System.out.println("Livres sauvegardés avec succès:");
            for (Book savedBook : savedBooks) {
                System.out.println("ID du livre: " + savedBook.getId_book());
                System.out.println("Titre du livre: " + savedBook.getTitle());
                System.out.println("Genre du livre: " + savedBook.getTopic().getTopic_name());
                System.out.println("ID de l'auteur: " + savedBook.getId_author());
                System.out.println();
            }

            */
        } catch (Exception e) {
            System.out.println("Erreur lors de la connexion à la base de données !");
            e.printStackTrace();
        }
    }
}
