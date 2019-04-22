package at.technikum.state;

import at.technikum.dto.Person;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Updated implements GameState {

  private static Updated INSTANCE = null;

  private Updated() {
  }

  public static Updated getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Updated();
    }

    return INSTANCE;
  }

  @Override
  public void purchase(GameControl control, Person person) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void download(GameControl control) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void install(GameControl control) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void start(GameControl control) { throw new UnsupportedOperationException(); }

  @Override
  public void play(GameControl control) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void readyForPlaying(GameControl control) {
    System.out.println("Game will be played..");
    control.setGameState(Ready.getInstance());
  }

  @Override
  public void block(GameControl control) {
 throw new UnsupportedOperationException();
  }

  @Override
  public void update(GameControl control) {
    System.out.println("Game is already updated");
  }

  @Override
  public void uninstall(GameControl control) {
   throw new UnsupportedOperationException();
  }

  @Override
  public String toString() {
    return "Game is in update state";
  }
}
