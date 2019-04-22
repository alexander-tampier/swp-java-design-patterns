package at.technikum.state;

import at.technikum.dto.Person;

/**
 * Invoker
 */
public class GameControl {

  private boolean owned;

  private final Game name;
  private Person person;
  private GameState gameState;

  public GameControl(Game name) {
    this.name = name;
    this.gameState = Available.getInstance();
    this.owned = false;
  }

  public boolean isOwned() {
    return owned;
  }

  public void setOwned(boolean owned) {
    this.owned = owned;
  }

  public Game getName() {
    return name;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public GameState getGameState() {
    return gameState;
  }

  public void setGameState(GameState gameState) {
    this.gameState = gameState;
  }

  public void purchase(Person person) {
    this.gameState.purchase(this, person);
  }

  public void download() {
    this.gameState.download(this);
  }

  public void install() {
    this.gameState.install(this);
  }

  public void start() {
    this.gameState.start(this);
  }

  public void play() {
    this.gameState.play(this);
  }

  public void update() {
    this.gameState.update(this);
  }

  public void uninstall() {
    this.gameState.uninstall(this);
  }

  public void readyForPlaying() {
    this.gameState.readyForPlaying(this);
  }

  public void block() {
    this.gameState.block(this);
  }


  public void returnToOwner() {
    //logic
    if (!this.owned && this.gameState instanceof Ready) {
      System.out.println("returning the game to its owner!");
      this.gameState.block(this);
      System.out.println("Game is no longer playable...");
    }
  }

  public void borrow() {
    /*available in store??*/
    if (!this.owned && this.gameState instanceof Available) {
      try {
        System.out.println("Sending borrow request");
        for (int i = 0; i < 3; i++) {
          System.out.print(". ");
          Thread.sleep(1000);
        }
        System.out.println("Accept response");
        this.gameState.purchase(this, person);
        setOwned(false);
        this.gameState.download(this);
        this.gameState.install(this);
        this.gameState.update(this);
        this.gameState.readyForPlaying(this);
        System.out.println("Game is now borrowed from your friend!");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }else{
      System.err.println("Game cant be borrowed");
    }
    // logic
    //his gamestate becomes blocked
    // our gamestate passes all states download/install etc. until ready
  }

  public void lend() {
    // logic
    if (this.owned && this.gameState instanceof Ready) {
      this.gameState.block(this);
      System.out.println("your Game will be lent to a friend!!");
      System.out.println("downloading/installing/updating the Game for your friend");
    }else{
      System.err.println("Game can't be lent");
    }
    // my gamestate goes over to blocked
    // his gamestate goes over to ready (and passes all other states until ready)
  }

  public void reclaim() {
    // logic
    if (this.owned && this.gameState instanceof Blocked) {
      try {
        System.out.println("waiting for your Friend to stop playing");
        Thread.sleep(1000);
        System.out.println("Signal received!");
        System.out.println("Blocking Game for your friend");
        System.out.println("Game reclaimed and is now ready to be played");
        this.gameState.readyForPlaying(this);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }else{
      System.err.println("Game can't be reclaimed");
    }
  }

}
