package ro.sapientia2015.story.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.sapientia2015.story.model.Comment;
import ro.sapientia2015.story.model.Story;

/**
 * @author Kiss Tibor
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
