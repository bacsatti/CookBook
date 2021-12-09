package hu.bme.homework.cookbook.dbservice.dto;

import lombok.Data;

@Data
public class CommentDto {
    private String username;
    private String content;
    private String date;
}
