package froggerFrames;

import java.io.File;
import froggerElements.BackgroundImage;
import froggerMaterialGenerator.ButtonGenerator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * <b>Represents the Start Screen of Frogger Game.<br></b>
 * <b>Singleton Design Pattern</b> <b>is applied to this class, so there is only <i>one</i> {@code StartScreen} instance throughout the game.</b>
 * @author GohXinYee
 *
 */
public class StartScreen {
	
	/** the StartScreen group that house all the elements appeared on the {@code StartScreen}*/
	private Group startgroup;
	/**the start button to start the game*/
	private Button startbtn;
	/**the info button to view the {@link froggerFrames.InfoScreen}*/
	private Button infobtn;
	/**the exit button to quit the game*/
	private Button exitbtn;
	/**the text area for player's username input*/
	private TextField username;
	/** a vertical box element in {@code StartScreen} to arrange the text and buttons elements vertically*/
	private VBox startscreenVBox;
	/** background image for Start Screen*/
	private BackgroundImage startscreenbackground;
	/**music player for startscreen*/
	private MediaPlayer mediaPlayer;
	/** the {@code StartScreen} instance.<br>
	 * declared as <i>static</i> to make sure there is only 1 {@code StartScreen} throughout the game*/
	private static StartScreen startscreen;
	

	
	/**
	 * This constructor will create a {@code StartScreen} for the game.<br>
	 * It has a username input area, start button, info button and an exit button.<br>
	 * The constructor is declared private to ensure that no other classes can create another {@code StartScreen} instance.
     * 
	 * @param ImageLink the link of the background image of {@code StartScreen} 
	 */
	private StartScreen(String ImageLink){
		
		
		//generate a background image
		startscreenbackground = new BackgroundImage(ImageLink,613,800);
		
		//create buttons
		ButtonGenerator btngenerator = new ButtonGenerator();
		startbtn = btngenerator.generate("file:src/main/resources/froggertextures/startbtnfrogger.png",140,50);
		infobtn = btngenerator.generate("file:src/main/resources/froggertextures/infobtnfrogger.png",140,50);
		exitbtn = btngenerator.generate("file:src/main/resources/froggertextures/exitbtnfrogger.png",140,50);
		
		//create a TextField to input username
		username = new TextField(null);
		username.setAlignment(Pos.CENTER);
		username.setMinSize(130, 40);
		
		//create a VBox, add all elements into the VBox
		startscreenVBox = new VBox(20,username,startbtn,infobtn,exitbtn); 
		startscreenVBox.setPrefWidth(150);
		startscreenVBox.setAlignment(Pos.BASELINE_CENTER);
		startscreenVBox.setPadding(new Insets(10));
		startscreenVBox.setTranslateX(220);
		startscreenVBox.setTranslateY(320);
		
		//create a Group as parent		
		startgroup = new Group();
		
		//add elements to parent Group 
		startgroup.getChildren().addAll(startscreenbackground,startscreenVBox);
	}
	
	
	/**
	 * Retrieve the {@code StartScreen} instance<br>
	 * declared as <i>public static</i> so that it can be called in other classes without an {@code StartScreen} object having to be created beforehand.
	 * @return {@code StartScreen} StartScreen instance
	 */
	public static StartScreen getInstance() {
		if(startscreen == null) {
			startscreen  = new StartScreen("file:src/main/resources/froggertextures/startscreenfrogger.png");
		}
		return startscreen;
	}
	
	/**play the music of StartScreen*/
	public void playMusic() {
		
		Media sound = new Media(new File("src/main/resources/froggermusic/StartScreenMusic_KomikuQuietSaturday.mp3").toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}
	
	/**stop the music of StartScreen*/
	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	

	/**
	 * access the group that holds all the elements of an {@code StartScreen} 
	 * @return {@code Group} {@link StartScreen#startgroup}
	 */
	public Group getStartScreenGroup() {
		return startgroup;
	}
	
	/**
	 * retrieve the start button on {@code StartScreen}
	 * @return {@link StartScreen#startbtn} {@code Button} element
	 */
	public Button getstartbtn() {
		//make sure the button is added into the group
		VBox vbox = (VBox) startgroup.getChildren().get(1);
		return (Button) vbox.getChildren().get(1);
	}
	
	/**
	 * retrieve the info button on {@code StartScreen}
	 * @return {@link StartScreen#infobtn} {@code Button} element
	 */
	public Button getinfobtn() {
		VBox vbox = (VBox) startgroup.getChildren().get(1);
		return (Button) vbox.getChildren().get(2);
	}
	
	/**
	 * retrieve the exit button on {@code StartScreen}
	 * @return {@link StartScreen#exitbtn} {@code Button} element
	 */
	public Button getexitbtn() {
		VBox vbox = (VBox) startgroup.getChildren().get(1);
		return (Button) vbox.getChildren().get(3);
	}
	
	/**
	 * retrieve the username entered by the player
	 * @return the {@link StartScreen#username} entered by the player in String format
	 */
	public String getusername() {
		return username.getText();
	}
	

}

