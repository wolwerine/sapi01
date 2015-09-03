package ro.sapientia2015.story.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.sapientia2015.story.dto.CommentDTO;
import ro.sapientia2015.story.dto.StoryDTO;
import ro.sapientia2015.story.exception.NotFoundException;
import ro.sapientia2015.story.model.Comment;
import ro.sapientia2015.story.model.Story;
import ro.sapientia2015.story.repository.CommentRepository;
import ro.sapientia2015.story.repository.StoryRepository;

import javax.annotation.Resource;

import java.util.List;

/**
 * @author Fulop Barna
 */
@Service
public class RepositoryCommentService implements CommentService {

    @Resource
    private CommentRepository repository;

    @Transactional
    @Override
    public Comment add(CommentDTO added) {

        Comment model = Comment.getBuilder(added.getTitle())
                .description(added.getDescription())
                .build();

        return repository.save(model);
    }

    @Transactional(rollbackFor = {NotFoundException.class})
    @Override
    public Comment deleteById(Long id) throws NotFoundException {
        Comment deleted = findById(id);
        repository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> findAll() {
       return repository.findAll();
    }

    @Transactional(readOnly = true, rollbackFor = {NotFoundException.class})
    @Override
    public Comment findById(Long id) throws NotFoundException {
        Comment found = repository.findOne(id);
        if (found == null) {
            throw new NotFoundException("No entry found with id: " + id);
        }

        return found;
    }

    @Transactional(rollbackFor = {NotFoundException.class})
    @Override
    public Comment update(CommentDTO updated) throws NotFoundException {
        Comment model = findById(updated.getId());
        model.update(updated.getDescription(), updated.getTitle());

        return model;
    }
}
