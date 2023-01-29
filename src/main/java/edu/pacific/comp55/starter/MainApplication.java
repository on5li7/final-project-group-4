package edu.pacific.comp55.starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };

	private SomePane somePane;
	private MenuPane menu;
	private DiningHallPane didningHall;
	private KitchenPane kitchen;
	private house House;
	private int count;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		//System.out.println("Hello, world!");
		House = new house();
		//House.start();
		somePane = new SomePane(this);
		menu = new MenuPane(this);
		kitchen = new KitchenPane(this, House);
		didningHall = new DiningHallPane(this, House);
		didningHall.populateRoom();
		setupInteractions();
		switchToMenu();
	}
	
	
	public void switchTODiningHall() {
		switchToScreen(didningHall);
	}
	
	public void switchToKitchen() {
		switchToScreen(kitchen);
	}

	public void switchToMenu() {
		playRandomSound();
		count++;
		switchToScreen(menu);
	}

	public void switchToSome() {
		playRandomSound();
		switchToScreen(somePane);
	}
	

	private void playRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
	
	public static void main(String[] args) {
		new MainApplication().start();
	}
}

/*debug function
create 3 fresh rooms, add them together as adjacent, need new house
generate individual room, and connect */
