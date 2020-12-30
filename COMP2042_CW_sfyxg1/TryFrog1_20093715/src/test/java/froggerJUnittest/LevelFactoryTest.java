package froggerJUnittest;


import froggerLevels.*;
import javafx.embed.swing.JFXPanel;

import froggerAnimal_Actions.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** Test {@link froggerLevels.LevelFactory} class*/
public class LevelFactoryTest{

	LevelFactory levelfactory;
	Level levela, levelb, levelc, leveld;
	Animal animal;
	JFXPanel p = new JFXPanel();

	@Before
	public void setUp() throws Exception {
		
		//create a levelfactory
		levelfactory=new LevelFactory();
		//create an animal
		animal = new Animal("file:src/main/resources/froggertextures/froggerUp.png");
	}


	/**
	 * Test LevelFactory in generating new Levels based on input
	 */
	@Test
	public void testLevelFactory() {
		
		//input "Level5" to level factory
		levela=levelfactory.getLevel("Level5",animal);
		//input "Level3" to level factory
		levelb=levelfactory.getLevel("Level3", animal);
		//input "Level5" to level factory
		levelc=levelfactory.getLevel("Level10",animal);
		//input "Level3" to level factory
		leveld=levelfactory.getLevel("Level7", animal);
		
		//check if the correct levels are created
		assertEquals(new Level5(animal).getClass(),levela.getClass());
		assertEquals(new Level3(animal).getClass(),levelb.getClass());
		assertEquals(new Level10(animal).getClass(),levelc.getClass());
		assertEquals(new Level7(animal).getClass(),leveld.getClass());
	}





}

