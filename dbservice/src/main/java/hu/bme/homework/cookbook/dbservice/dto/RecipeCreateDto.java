package hu.bme.homework.cookbook.dbservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeCreateDto {
    private String title;
    private List<String> ingredients;
    private String process;
}
