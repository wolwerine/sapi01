package ro.sapientia2015.story.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.sapientia2015.story.model.Sprint;

/**
 * @author Kiss Tibor
 */
public interface SprintRepository extends JpaRepository<Sprint, Long> {
}
