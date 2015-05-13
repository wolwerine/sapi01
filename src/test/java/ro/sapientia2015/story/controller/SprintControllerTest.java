package ro.sapientia2015.story.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.context.MessageSource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import ro.sapientia2015.story.StoryTestUtil;
import ro.sapientia2015.story.config.UnitTestContext;
import ro.sapientia2015.story.controller.StoryController;
import ro.sapientia2015.story.dto.SprintDTO;
import ro.sapientia2015.story.dto.StoryDTO;
import ro.sapientia2015.story.exception.NotFoundException;
import ro.sapientia2015.story.model.Sprint;
import ro.sapientia2015.story.model.Story;
import ro.sapientia2015.story.service.SprintService;
import ro.sapientia2015.story.service.StoryService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Kiss Tibor
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UnitTestContext.class})
public class SprintControllerTest {

    private SprintController controller;

    private SprintService serviceMock;

    @Resource
    private Validator validator;
    
    @Before
    public void setUp() {
        controller = new SprintController();

        serviceMock = mock(SprintService.class);
        ReflectionTestUtils.setField(controller, "service", serviceMock);
    }

    @Test
    public void sprintList1() {
        BindingAwareModelMap model = new BindingAwareModelMap();

        String view = controller.listSprints(model);

        assertEquals("sprint/list", view);
     }

    @Test
    public void sprintList2() {
        BindingAwareModelMap model = new BindingAwareModelMap();

        controller.listSprints(model);

        List<Sprint> sprints =  (List<Sprint>)model.asMap().get("sprints");
        assertNotNull(sprints);
     }

    @Test
    public void sprintList3() {
        BindingAwareModelMap model = new BindingAwareModelMap();

        controller.listSprints(model);

        verify(serviceMock, times(1)).findAll();
        verifyNoMoreInteractions(serviceMock);
     }
    
    @Test
    public void sprintList4() {
        BindingAwareModelMap model = new BindingAwareModelMap();       
        List<Sprint> list = new ArrayList<Sprint>();
        list.add(new Sprint());
        when(serviceMock.findAll()).thenReturn(list);

        controller.listSprints(model);
        
        List<Sprint> sprints =  (List<Sprint>)model.asMap().get("sprints");

        assertEquals(1, sprints.size());
     }
    private BindingResult bindAndValidate(HttpServletRequest request, Object formObject) {
        WebDataBinder binder = new WebDataBinder(formObject);
        binder.setValidator(validator);
        binder.bind(new MutablePropertyValues(request.getParameterMap()));
        binder.getValidator().validate(binder.getTarget(), binder.getBindingResult());
        return binder.getBindingResult();
    }

    @Test
    public void add() {
        SprintDTO formObject = new SprintDTO();

        formObject.setTitle("title");
        formObject.setDescription("desc");
        
        Sprint model = Sprint.getBuilder("title")
        		.description("desc").build();
        
        when(serviceMock.add(formObject)).thenReturn(model);

        MockHttpServletRequest mockRequest = new MockHttpServletRequest("POST", "/sprint/add");
        BindingResult result = bindAndValidate(mockRequest, formObject);

        RedirectAttributesModelMap attributes = new RedirectAttributesModelMap();


        String view = controller.add(formObject, result, attributes);

        verify(serviceMock, times(1)).add(formObject);
        verifyNoMoreInteractions(serviceMock);

        String expectedView = "redirect:/sprint/list";
        assertEquals(expectedView, view);
    }

    
    @Test
    public void addEmptyStory1() {
    	
        SprintDTO formObject = new SprintDTO();

        formObject.setTitle("");
        formObject.setDescription("");
       
        MockHttpServletRequest mockRequest = new MockHttpServletRequest("POST", "/sprint/add");
        BindingResult result = bindAndValidate(mockRequest, formObject);

        RedirectAttributesModelMap attributes = new RedirectAttributesModelMap();

        String view = controller.add(formObject, result, attributes);

        assertEquals(SprintController.VIEW_ADD, view);
    }
    
    @Test
    public void addTooLongStoryTitle() {
    	
        SprintDTO formObject = new SprintDTO();

        formObject.setTitle("TooLongTitleeeeeeeeeeeeee");
        formObject.setDescription("");
       
        MockHttpServletRequest mockRequest = new MockHttpServletRequest("POST", "/sprint/add");
        BindingResult result = bindAndValidate(mockRequest, formObject);

        RedirectAttributesModelMap attributes = new RedirectAttributesModelMap();

        String view = controller.add(formObject, result, attributes);

        assertEquals(SprintController.VIEW_ADD, view);
    }
    
    
    
    
}
