package at.technikum.state;

import at.technikum.dto.Person;

public class Ready implements GameState {

  private static Ready INSTANCE = null;

  private Ready() {
  }

  public static Ready getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Ready();
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
    System.out.println("Game will be started..");
    control.setGameState(Started.getInstance());
  }

  @Override
  public void play(GameControl control) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void update(GameControl control) {
    System.out.println("Game will be updated..");
    control.setGameState(Updated.getInstance());
  }

  @Override
  public void uninstall(GameControl control) {
    System.out.println("Game will be uninstalled..");
    control.setGameState(Uninstalled.getInstance());
  }

  @Override
  public void readyForPlaying(GameControl control) {
    System.out.println("Game is already ready to be played ;)");
  }

  @Override
  public void block(GameControl control) {
    System.out.println("Game will be blocked..");
    control.setGameState(Blocked.getInstance());

  }


  @Override
  public String toString() {
    return "Game is in Ready State";
  }
}
