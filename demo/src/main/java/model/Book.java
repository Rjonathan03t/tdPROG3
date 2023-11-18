package model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Book {
    private int id_book;
    private String title;
    private int page_number;
    private String topic;
    private int id_author;
}
