package hu.bme.homework.cookbook.dbservice.mapper;

import hu.bme.homework.cookbook.dbservice.dto.CommentCreateDto;
import hu.bme.homework.cookbook.dbservice.dto.CommentDto;
import hu.bme.homework.cookbook.dbservice.persistance.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper {

    public CommentDto commentEntityToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setUsername(comment.getUsername());
        commentDto.setContent(comment.getContent());
        commentDto.setDate(comment.getDate());

        return commentDto;
    }

    public Comment commentCreateDtoToEntity(CommentCreateDto commentCreateDto) {
        Comment comment = new Comment();
        comment.setUsername(commentCreateDto.getUserName());
        comment.setContent(commentCreateDto.getComment());
        return comment;
    }

}
