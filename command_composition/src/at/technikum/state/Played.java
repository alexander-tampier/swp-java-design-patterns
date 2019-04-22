package at.technikum.state;

import at.technikum.dto.Person;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Played implements GameState {

  private static Played INSTANCE = null;

  private Played() {
  }

  public static Played getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Played();
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
    throw new UnsupportedOperationException();
  }

  @Override
  public void play(GameControl control) {
    System.out.println("Game is already played");
  }

  @Override
  public void update(GameControl control) {
   throw new UnsupportedOperationException();
  }

  @Override
  public void readyForPlaying(GameControl control) {
    System.out.println("Game will be ready..");
    control.setGameState(Ready.getInstance());

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
    return "Game is in play state";
  }
}
