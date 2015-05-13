package ro.sapientia2015.story.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.sapientia2015.story.dto.SprintDTO;
import ro.sapientia2015.story.exception.NotFoundException;
import ro.sapientia2015.story.model.Sprint;
import ro.sapientia2015.story.repository.SprintRepository;

/**
 * @author Kiss Tibor
 */
@Service
public class RepositorySprintService implements SprintService {

    @Resource
    private SprintRepository repository;

    @Transactional
    @Override
    public Sprint add(SprintDTO added) {

        Sprint model = added.getBuilder().setTitle(added.getTitle())
                .description(added.getDescription())
                .build();

        return repository.save(model);
    }

    @Transactional(rollbackFor = {NotFoundException.class})
    @Override
    public Sprint deleteById(Long id) throws NotFoundException {
        Sprint deleted = findById(id);
        repository.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Sprint> findAll() {
       return repository.findAll();
    }

    @Transactional(readOnly = true, rollbackFor = {NotFoundException.class})
    @Override
    public Sprint findById(Long id) throws NotFoundException {
        Sprint found = repository.findOne(id);
        if (found == null) {
            throw new NotFoundException("No entry found with id: " + id);
        }

        return found;
    }

    @Transactional(rollbackFor = {NotFoundException.class})
    @Override
    public Sprint update(SprintDTO updated) throws NotFoundException {
        Sprint model = findById(updated.getId());
        model.update(updated.getDescription(), updated.getTitle());

        return model;
    }
}
