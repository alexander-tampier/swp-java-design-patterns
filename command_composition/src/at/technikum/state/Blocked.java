package at.technikum.state;

import at.technikum.dto.Person;

public class Blocked implements GameState{

  private static Blocked INSTANCE = null;

  private Blocked(){}

  public static Blocked getInstance() {

    if(INSTANCE==null){
      INSTANCE = new Blocked();
    }

    return INSTANCE;
  }

  @Override
  public void purchase(GameControl control,Person person) {
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
    System.out.println("Game will be ready..");
    control.setGameState(Ready.getInstance());
  }

  @Override
  public void block(GameControl control) {
    System.out.println("Game is already blocked..");
  }


  @Override
  public String toString() {
    return "Game is blocked!";
  }
}
