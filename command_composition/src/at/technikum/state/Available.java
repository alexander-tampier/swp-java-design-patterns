package at.technikum.state;

import at.technikum.dto.Person;

public class Available implements GameState{

  private static Available INSTANCE = null;

  private Available() {
  }

  public static Available getInstance() {
    if(INSTANCE == null){
      INSTANCE = new Available();
    }

    return INSTANCE;
  }

  @Override
  public void purchase(GameControl control, Person person) {
    System.out.println("Game will be purchased..");
    control.setPerson(person);
    control.setOwned(true);
    control.setGameState(Purchased.getInstance());
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
    throw new UnsupportedOperationException();
  }

  @Override
  public void update(GameControl control) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void uninstall(GameControl control) {
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
  public String toString() {
    return "Game is available in store!";
  }
}
