package ro.sapientia2015.story.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.sapientia2015.story.model.Story;

/**
 * @author Kiss Tibor
 */
public interface StoryRepository extends JpaRepository<Story, Long> {
}
