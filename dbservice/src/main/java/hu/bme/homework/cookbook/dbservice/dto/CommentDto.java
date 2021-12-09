package hu.bme.homework.cookbook.dbservice.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class CommentDto {
    private String username;
    private String content;
    private Instant date;
}
