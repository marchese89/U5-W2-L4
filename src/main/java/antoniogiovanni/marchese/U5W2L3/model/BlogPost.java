package antoniogiovanni.marchese.U5W2L3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "blog_post")
public class BlogPost {
    @Id
    @GeneratedValue
    private UUID id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private Integer tempoDiLettura;//minuti
    @ManyToOne
    @JoinColumn(name = "autore_id")
    @JsonBackReference
    private AutoreBlogPost autoreBlogPost;
}
