import crudOps.AuthorCrud;
import crudOps.BookCrud;
import model.Author;
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
            //BookCrud bookCrud = new BookCrud(connection);

           //bookCrud.findAll();

            //pour tester la methode delete
            /*Book bookToDelete = new Book();
            bookToDelete.setId_book(6);
            Book deletedBook = bookCrud.delete(bookToDelete);

            System.out.println("book deleted with success:");
            System.out.println("ID book: " + deletedBook.getId_book());


             */
            //pour tester la methode save
           /* Topic topic = new Topic();
            topic.setTopic_name("OTHER");


            Book bookToSave = new Book();
            bookToSave.setId_book(4);
            bookToSave.setTitle("Harry Potter");
            bookToSave.setTopic(topic);
            bookToSave.setId_author(1);


            Book savedBook = bookCrud.save(bookToSave);

            System.out.println("book saved with success:");
            System.out.println("ID book: " + savedBook.getId_book());
            System.out.println("Tittle: " + savedBook.getTitle());
            System.out.println("Topic : " + savedBook.getTopic().getTopic_name());
            System.out.println("ID author: " + savedBook.getId_author());


            */
            //pour tester la methode saveAll

          /* List<Book> booksToSave = new ArrayList<>();
            booksToSave.add(new Book(5, "Le Seigneur des Anneaux", new Topic("OTHER"), 2));
            booksToSave.add(new Book(6, "Da Vinci Code", new Topic("ROMANCE"), 3));

            List<Book> savedBooks = bookCrud.saveAll(booksToSave);

            System.out.println("books have been saved successfully:");
            for (Book savedBook : savedBooks) {
                System.out.println("ID book: " + savedBook.getId_book());
                System.out.println("title: " + savedBook.getTitle());
                System.out.println("topic: " + savedBook.getTopic().getTopic_name());
                System.out.println("ID author: " + savedBook.getId_author());
                System.out.println();
            }

           */



            AuthorCrud authorCrud = new AuthorCrud(connection);
            //authorCrud.findAll();

            //pour tester la methode delete
            Author authorToDelete = new Author();
            authorToDelete.setId_author(4);
            Author deletedAuthor = authorCrud.delete(authorToDelete);

            System.out.println("author deleted with success:");
            System.out.println("ID author: " + deletedAuthor.getId_author());


            //pour tester la methode save
           /* Author authorToSave = new Author();
           authorToSave.setId_author(6);
           authorToSave.setName("ilay");
           authorToSave.setGender("M");


            Author savedAuthor = authorCrud.save(authorToSave);

            System.out.println("Authors have been saved successfully:");
            System.out.println("ID author: " + savedAuthor.getId_author());
            System.out.println("name: " + savedAuthor.getName());
            System.out.println("gender: " + savedAuthor.getGender());


            */


            //methode saveAll
            /*List<Author> authorsToSave = new ArrayList<>();
            authorsToSave.add(new Author(4, "bege" , "M"));
            authorsToSave.add(new Author(5, "labelle" , "F"));

            List<Author> savedAuthors = authorCrud.saveAll(authorsToSave);

            System.out.println("authors has been saved successfully:");
            for (Author savedAuthor : savedAuthors) {
                System.out.println("ID author: " + savedAuthor.getId_author());
                System.out.println("name: " + savedAuthor.getName());
                System.out.println("gender: " + savedAuthor.getGender());

            }

             */



        } catch (Exception e) {
            System.out.println("Erreur lors de la connexion à la base de données !");
            e.printStackTrace();
        }
    }
}
