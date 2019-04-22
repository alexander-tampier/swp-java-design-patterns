package at.technikum.state;

import at.technikum.dto.Person;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Started implements GameState {

  private static Started INSTANCE = null;

  private Started() {
  }

  public static Started getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Started();
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
  public void start(GameControl control) {
    System.out.println("Game is already started");
  }

  @Override
  public void play(GameControl control) {
    System.out.println("Game will be played..");
    control.setGameState(Played.getInstance());
  }

  @Override
  public void update(GameControl control) {
    throw new UnsupportedOperationException();
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
  public void uninstall(GameControl control) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String toString() {
    return "Game is in start state";
  }
}
