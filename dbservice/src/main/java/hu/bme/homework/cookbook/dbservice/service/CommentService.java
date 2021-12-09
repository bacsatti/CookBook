package hu.bme.homework.cookbook.dbservice.service;

import hu.bme.homework.cookbook.dbservice.dto.CommentCreateDto;
import hu.bme.homework.cookbook.dbservice.dto.CommentDto;
import hu.bme.homework.cookbook.dbservice.mapper.CommentMapper;
import hu.bme.homework.cookbook.dbservice.persistance.Comment;
import hu.bme.homework.cookbook.dbservice.persistance.CommentRepository;
import hu.bme.homework.cookbook.dbservice.persistance.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CommentService {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentRepository commentRepository;

    public CommentDto createComment(CommentCreateDto commentCreateDto) {
        Comment comment = commentMapper.commentCreateDtoToEntity(commentCreateDto);
        Recipe recipe = recipeService.getRecipeEntityById(commentCreateDto.getRecipeId());
        comment.setRecipe(recipe);
        comment.setDate(Instant.now());
        comment = commentRepository.save(comment);

        return commentMapper.commentEntityToDto(comment);
    }
}
