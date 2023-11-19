import crudOps.AuthorCrud;
import crudOps.BookCrud;
import crudOps.SubscriberCrud;
import model.Author;
import model.Book;
import model.Subscriber;
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
            //============================BOOKCRUDOPERATIONS==============================
            //BookCrud bookCrud = new BookCrud(connection);
            //------FINDALL
            //bookCrud.findAll();

            //-----DELETE
            /*Book bookToDelete = new Book();
            bookToDelete.setId_book(6);
            Book deletedBook = bookCrud.delete(bookToDelete);

            System.out.println("book deleted with success:");
            System.out.println("ID book: " + deletedBook.getId_book());


             */
            //------SAVE
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
            //------SAVEALL

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


            //====================AUTHORCRUDOPERATIONS================================
            //AuthorCrud authorCrud = new AuthorCrud(connection);
            //--------FINDALL
            //authorCrud.findAll();

            //-------DELETE
           /* Author authorToDelete = new Author();
            authorToDelete.setId_author(4);
            Author deletedAuthor = authorCrud.delete(authorToDelete);

            System.out.println("author deleted with success:");
            System.out.println("ID author: " + deletedAuthor.getId_author());


            */

            //-------SAVE
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


            //---------SAVEALL
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

            //===================SUBSCRIBERCRUDOPERATIONS=======================
            SubscriberCrud subscriberCrud = new SubscriberCrud(connection);
            //--------FINDALL
            //subscriberCrud.findAll();

            //------SAVEALL
           /* List<Subscriber> subscribersToSave = new ArrayList<>();
            subscribersToSave.add(new Subscriber(4, "fila" , "filacode"));
            subscribersToSave.add(new Subscriber(5, "jose" , "josecode"));

            List<Subscriber> savedSubscribers = subscriberCrud.saveAll(subscribersToSave);

            System.out.println("subs have been saved successfully:");
            for (Subscriber savedSubscriber : savedSubscribers) {
                System.out.println("ID user: " + savedSubscriber.getId_user());
                System.out.println("name: " + savedSubscriber.getName());
                System.out.println("password: " + savedSubscriber.getPassword());

            }

            */
            //-------SAVE
            /*Subscriber subscriberToSave = new Subscriber(6,"ilay","ilaycode");

            Subscriber savedSubscriber = subscriberCrud.save(subscriberToSave);

            System.out.println("subscribers have been saved successfully:");
            System.out.println("ID sub: " + savedSubscriber.getId_user());
            System.out.println("name: " + savedSubscriber.getName());
            System.out.println("password: " + savedSubscriber.getPassword());



             */

            //--------DELETE
            Subscriber SubscriberToDelete = new Subscriber(6,"ilay","ilaycode");
            Subscriber deletedSubscriber = subscriberCrud.delete(SubscriberToDelete);

            System.out.println("subscriber deleted with success:");
            System.out.println("ID sub: " + deletedSubscriber.getId_user());



        } catch (Exception e) {
            System.out.println("Erreur lors de la connexion à la base de données !");
            e.printStackTrace();
        }
    }
}
