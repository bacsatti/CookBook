package hu.bme.homework.cookbook.dbservice.persistance;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ElementCollection
    private List<String> ingredients;
    private String process;

    public Recipe(String title, List<String> ingredients, String process) {
        this.title = title;
        this.ingredients = ingredients;
        this.process = process;
    }
}
