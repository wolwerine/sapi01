package ro.sapientia2015.story.model;

import org.junit.Test;

import static junit.framework.Assert.*;

public class StoryNewTest {

	@Test
	public void testTitle(){
		Story story = Story.getBuilder("Hello").build();
		assertNotNull(story.getTitle());
	}
	
}
