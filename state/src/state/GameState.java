package state;


public enum GameState {
  //gekauft“, heruntergeladen, installiert, gestartet und gespielt, deinstalliert, aktualisiert
  PURCHASE(new Purchase()),
  DOWNLOAD(new Download()),
  INSTALL(new Install()),
  START(new Start()),
  PLAY(new Play()),
  UNINSTALL(new Uninstall()),
  UPDATE(new Update());

  private final State state;

  GameState(State state) {
    this.state = state;
  }

  public State getState() {
    return state;
  }
}
