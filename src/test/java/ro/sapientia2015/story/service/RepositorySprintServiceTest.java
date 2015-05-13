package ro.sapientia2015.story.service;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.test.util.ReflectionTestUtils;

import ro.sapientia2015.story.StoryTestUtil;
import ro.sapientia2015.story.dto.SprintDTO;
import ro.sapientia2015.story.dto.StoryDTO;
import ro.sapientia2015.story.exception.NotFoundException;
import ro.sapientia2015.story.model.Sprint;
import ro.sapientia2015.story.model.Story;
import ro.sapientia2015.story.repository.SprintRepository;
import ro.sapientia2015.story.repository.StoryRepository;
import ro.sapientia2015.story.service.RepositoryStoryService;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * @author Kiss Tibor
 */
public class RepositorySprintServiceTest {

    private RepositorySprintService service;

    private SprintRepository repositoryMock;

    @Before
    public void setUp() {

    	service = new RepositorySprintService();
        repositoryMock = mock(SprintRepository.class);
        ReflectionTestUtils.setField(service, "repository", repositoryMock);
    }


    @Test
    public void findAll() {
        List<Sprint> models = new ArrayList<Sprint>();
        when(repositoryMock.findAll()).thenReturn(models);

        List<Sprint> actual = service.findAll();

        verify(repositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(repositoryMock);

        assertEquals(models, actual);
    }

    @Test
    public void addTest1() {
        
    	SprintDTO dto = new SprintDTO();
    	dto.setTitle("Dude");
    	dto.setDescription("Da Dude");
        Sprint.Builder builder = mock(Sprint.Builder.class);
    	
    	
    	Sprint model = Sprint.getBuilder(dto.getTitle())
                .description(dto.getDescription())
                .build();
    	dto.setBuilder(builder);
    	when(builder.build()).thenReturn(model);
    	when(builder.setTitle(dto.getTitle())).thenReturn(builder);
    	when(builder.description(dto.getDescription())).thenReturn(builder);
    	
    	model.setCreationTime(DateTime.now());
    	model.setId(0l);
    	model.setModificationTime(DateTime.now());
    	model.setVersion(0);
    	
        when(repositoryMock.save(model)).thenReturn(model);

        Sprint actual = service.add(dto);

        verify(repositoryMock, times(1)).save(model);
        verifyNoMoreInteractions(repositoryMock);

        assertEquals(model, actual);
    }
    
    
    
 }
