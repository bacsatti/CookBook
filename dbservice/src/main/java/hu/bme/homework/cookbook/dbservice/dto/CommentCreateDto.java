package hu.bme.homework.cookbook.dbservice.dto;

import lombok.Data;

@Data
public class CommentCreateDto {
    private Long recipeId;
    private String comment;
    private String userName;
}
