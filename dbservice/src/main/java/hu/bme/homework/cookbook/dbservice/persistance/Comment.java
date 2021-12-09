package hu.bme.homework.cookbook.dbservice.persistance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String content;
    private String date; //TODO use Instant?

    @ManyToOne
    @JoinColumn(name="recipe_id", nullable=false)
    private Recipe recipe;
}
