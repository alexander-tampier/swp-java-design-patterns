package at.technikum.state;

import at.technikum.dto.Person;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Installed implements GameState {

  private static Installed INSTANCE = null;

  private Installed() {
  }

  public static Installed getInstance() {
    if(INSTANCE==null)
      INSTANCE = new Installed();

    return INSTANCE;
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
  public void purchase(GameControl control, Person person) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void download(GameControl control) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void install(GameControl control) {
    System.out.println("GameState is already installed");
  }

  @Override
  public void start(GameControl control) { throw new UnsupportedOperationException(); }

  @Override
  public void play(GameControl control) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void update(GameControl control) {
    System.out.println("Game will be updated");
    control.setGameState(Updated.getInstance());
  }

  @Override
  public void uninstall(GameControl control) {
    System.out.println("Game will be uninstalled");
    control.setGameState(Uninstalled.getInstance());
  }


  @Override
  public String toString() {
    return "GameControl is in install state";
  }
}
