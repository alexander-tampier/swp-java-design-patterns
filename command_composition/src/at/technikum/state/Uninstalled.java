package at.technikum.state;

import at.technikum.dto.Person;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Uninstalled implements GameState {

  private static Uninstalled INSTANCE = null;

  private Uninstalled() {
  }

  public static Uninstalled getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Uninstalled();
    }

    return INSTANCE;
  }

  @Override
  public void purchase(GameControl control, Person person) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void download(GameControl control) {
    System.out.println("Game will be downloaded..");
    control.setGameState(Downloaded.getInstance());
  }

  @Override
  public void install(GameControl control) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void start(GameControl control) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void play(GameControl control) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void update(GameControl control) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void uninstall(GameControl control) {
    System.out.println("Game is already uninstalled");
  }

  @Override
  public void readyForPlaying(GameControl control) {
 throw new UnsupportedOperationException();
  }

  @Override
  public void block(GameControl control) {
 throw new UnsupportedOperationException();
  }

  @Override
  public String toString() {
    return "Game is in uninstall state";
  }
}
