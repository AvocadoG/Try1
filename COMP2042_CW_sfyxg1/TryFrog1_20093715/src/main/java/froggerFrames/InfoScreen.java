package froggerFrames;

import froggerElements.BackgroundImage;
import froggerMaterialGenerator.ButtonGenerator;
import froggerMaterialGenerator.TextGenerator;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * <b>Represents the Information Screen of Frogger Game.<br>
 * Singleton Design Pattern is applied to this class, so there is only <i>one</i> {@code InfoScreen} instance throughout the game.</b>
 * @author GohXinYee
 *
 */
public class InfoScreen {

	/** the InfoScreen group that house all the elements appeared on the {@code InfoScreen}*/
	private Group infogroup;
	/** a return button on {@code InfoScreen} */
	private Button backtostart;
	/** a vertical box element in {@code InfoScreen} to arrange the text and buttons vertically*/
	private VBox infoscreenVBox;
	/** background image of {@code InfoScreen}*/
	private BackgroundImage infobackground;
	/** the {@code InfoScreen} instance.<br>
	 * declared as <i>static</i> to make sure there is only 1 {@code InfoScreen} throughout the game*/
	private static InfoScreen infoscreen;
	

	
	/**
	 * This constructor will create an {@code InfoScreen}, displaying the instructions to play the game.<br>
	 * The constructor is declared private to ensure that no other classes can create another {@code InfoScreen} instance except itself.
	 * @param ImageLink the link of the background image of {@code InfoScreen}
	 */
	private InfoScreen (String ImageLink){
		
		//generate a background image
	    infobackground = new BackgroundImage(ImageLink,613,800);
	    
		//create a back-to-start button
	    ButtonGenerator btngenerator = new ButtonGenerator();
		backtostart = btngenerator.generate("file:src/main/resources/froggertextures/backtostartbtnfrogger.png",140,50);
		
		//create subheading and instructions text
		TextGenerator txtgenerator = new TextGenerator();
		Text subheading = txtgenerator.generate("How to Play??", "ChickenPie",19,TextAlignment.CENTER,Color.CHOCOLATE);
		Text instructions = txtgenerator.generate(getinstructions(),"Phosb___",14,TextAlignment.JUSTIFY,Color.BLACK);
	    instructions.setWrappingWidth(500);

	    //set up a VBox to add in the elements
		infoscreenVBox = new VBox(15,subheading,instructions,backtostart);
	    infoscreenVBox.setMinSize(600,800);
	    infoscreenVBox.setMaxSize(600, 800);
	    infoscreenVBox.setAlignment(Pos.CENTER);

	    //create a Group as parent
	    //add the elements to a parent Group
	  	infogroup = new Group();
		infogroup.getChildren().addAll(infobackground,infoscreenVBox);
	}
	


	/**
	 * to retrieve the {@code InfoScreen} instance<br>
	 * declared as <i>public static</i> so that it can be called in other classes without an {@code InfoScreen} object having to be created beforehand.
	 * @return {@code InfoScreen} InfoScreen instance
	 */
	public static InfoScreen getInstance() {
		
		if(infoscreen==null) {
			infoscreen = new InfoScreen("file:src/main/resources/froggertextures/infoscreenfrogger.png");
		}
		return infoscreen;
	}

	
	/**
	 * Access the group that holds all the elements of an {@code InfoScreen} 
	 * @return {@code Group} {@link InfoScreen#infogroup}
	 */
	public Group getInfoScreenGroup() {
		return infogroup;
	}
	
	/**
	 * Retrieve the back-to-start button on {@code InfoScreen}
	 * @return {@link InfoScreen#backtostart} {@code Button} element
	 */
	public Button getbacktostartbtn() {
		VBox vbox = (VBox) getInfoScreenGroup().getChildren().get(1);
		return (Button) vbox.getChildren().get(2);
	}
	
	/**
	 * Retrieve game instructions
	 * @return the game instructions in String format
	 */
	public String getinstructions() {
		return  "A key to move Frogger to the left\n" +
				"D key to move Frogger to the right\n" +
				"S key to move Frogger back\n" +
				"W key to make Frogger jump\n\n" +				                                                                     
				"RULES\n\n" +
				"The goals are sending your Frog to all the 5 empty destinations on the other side. " +
				"\nYour frog has to AVOID any trucks, cars and monsters on the way and cross the river by jumping onto the logs and turtles.\n" +
				"\nGreen turtles will submerge into the river from time to time. Red turtles will turn into Green turtles too! " +
				"When Frogger jumps onto the Green Turtle and the Green Turtle submerges, Frogger will sink into the river and DIE.\nThe BOMBS on the Logs will kill your Frog too!."+
				"\n\n5points for each successful forward movement.\n10points for reaching each destination. Note that SOME destinations have COINS! If your Frog manages to collect all the coins CONTINUOUSLY, it can proceed to the Next level RIGHT AWAY and get extra 50 points!" +
				"\n\nMINUS 10points for getting killed by the Trucks, Cars, Monsters, Bombs or drowning into the river. \nMINUS 5points for bumping into the grass block.\n" +
				"\n10 Levels in total, Level Up upon reaching all destinations at each level. The speed of the game will increase as your Frog levels up."+
				" Beware of the Monster!";
	}

	
	
}
