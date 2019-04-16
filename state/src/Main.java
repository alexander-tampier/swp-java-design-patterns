import state.GameState;

public class Main {

  public static void main(String[] args) {
    OnlineStore onlineStore = new OnlineStore();
    onlineStore.process();
    onlineStore.setGameState(GameState.DOWNLOAD);
    onlineStore.process();
  }
}
