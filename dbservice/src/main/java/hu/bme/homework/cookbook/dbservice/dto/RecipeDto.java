package hu.bme.homework.cookbook.dbservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeDto {

    private Long id;
    private String title;
    private List<String> ingredients;
    private String process;
    private List<CommentDto> comments;

}
