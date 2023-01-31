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
	private WineCellarPane wineCellar;
	private GreenHousePane greenHouse;
	private HallwayPane hallWay;
	private StudyPane Study;
	private WorkshopPane workShop;
	private ApothecaryPane apothecary;
	private ArmoryPane armory;
	private DungeonPane dungeon;
	private BalconyPane balcony;
	private Outdoors3Pane outdoors3;
	private Outdoors2Pane outdoors2;
	private Outdoors1Pane outdoors1;
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
		wineCellar = new WineCellarPane(this, House);
		greenHouse = new GreenHousePane(this,House);
		hallWay = new HallwayPane(this,House);
		Study = new StudyPane(this,House);
		workShop = new WorkshopPane(this,House);
		apothecary = new ApothecaryPane(this,House);
		armory = new ArmoryPane(this,House);
		dungeon = new DungeonPane(this,House);
		balcony = new BalconyPane(this,House);
		outdoors3 = new Outdoors3Pane(this,House);
		outdoors2 = new Outdoors2Pane(this,House);
		outdoors1 = new Outdoors1Pane(this,House);
		didningHall.populateRoom();
		setupInteractions();
		switchToMenu();
	}
	
	public void switchToWineCellar() {
		switchToScreen(wineCellar);
	}
	
	public void switchTODiningHall() {
		switchToScreen(didningHall);
	}
	
	public void switchToKitchen() {
		switchToScreen(kitchen);
	}
	
	public void switchToGreenHouse() {
		switchToScreen(greenHouse);
	}
	
	public void switchToHallway() {
		switchToScreen(hallWay);
	}
	
	public void switchToStudy() {
		switchToScreen(Study);
	}
	
	public void switchToWorkshop() {
		switchToScreen(workShop);
	}
	
	public void switchToApothecary() {
		switchToScreen(apothecary);
	}
	
	public void switchToArmory() {
		switchToScreen(armory);
	}
	
	public void switchToDungeon() {
		switchToScreen(dungeon);
	}
	
	public void switchToBalcony() {
		switchToScreen(balcony);
	}
	
	public void switchToOutdoors3() {
		switchToScreen(outdoors3);
	}
	
	public void switchToOutdoors2() {
		switchToScreen(outdoors2);
	}
	
	public void switchToOutdoors1() {
		switchToScreen(outdoors1);
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
