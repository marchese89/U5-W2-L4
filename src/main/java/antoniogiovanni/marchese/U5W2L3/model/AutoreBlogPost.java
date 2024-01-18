package antoniogiovanni.marchese.U5W2L3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "autori_blog_post")
public class AutoreBlogPost {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;
    @OneToMany(mappedBy = "autoreBlogPost")
    @JsonManagedReference
    //@JsonIgnore <- rimuove l'elemento dal json
    private List<BlogPost> blogPostList;
}
