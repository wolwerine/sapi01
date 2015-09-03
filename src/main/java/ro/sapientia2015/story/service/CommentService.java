package ro.sapientia2015.story.service;

import java.util.List;

import ro.sapientia2015.story.dto.CommentDTO;
import ro.sapientia2015.story.dto.StoryDTO;
import ro.sapientia2015.story.exception.NotFoundException;
import ro.sapientia2015.story.model.Comment;
import ro.sapientia2015.story.model.Story;

/**
 * @author Fulop Barna
 */
public interface CommentService {

    /**
     * Adds a new to-do entry.
     * @param added The information of the added to-do entry.
     * @return  The added to-do entry.
     */
    public Comment add(CommentDTO added);

    /**
     * Deletes a to-do entry.
     * @param id    The id of the deleted to-do entry.
     * @return  The deleted to-do entry.
     * @throws NotFoundException    if no to-do entry is found with the given id.
     */
    public Comment deleteById(Long id) throws NotFoundException;

    /**
     * Returns a list of to-do entries.
     * @return
     */
    public List<Comment> findAll();

    /**
     * Finds a to-do entry.
     * @param id    The id of the wanted to-do entry.
     * @return  The found to-entry.
     * @throws NotFoundException    if no to-do entry is found with the given id.
     */
    public Comment findById(Long id) throws NotFoundException;

    /**
     * Updates the information of a to-do entry.
     * @param updated   The information of the updated to-do entry.
     * @return  The updated to-do entry.
     * @throws NotFoundException    If no to-do entry is found with the given id.
     */
    public Comment update(CommentDTO updated) throws NotFoundException;
}
