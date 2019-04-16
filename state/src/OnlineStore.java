import static state.GameState.DOWNLOAD;
import static state.GameState.INSTALL;
import static state.GameState.PLAY;
import static state.GameState.PURCHASE;
import static state.GameState.START;
import static state.GameState.UNINSTALL;
import static state.GameState.UPDATE;

import java.util.logging.Logger;
import state.GameState;

public class OnlineStore {

  private static final Logger LOGGER = Logger.getLogger(OnlineStore.class.getName());

  private GameState gameState;

  public OnlineStore() {
    this.gameState = PURCHASE;
  }

  public GameState getGameState() {
    return gameState;
  }

  public void setGameState(GameState newGameState) {
    if(newGameState != gameState){
      if(!isStateAllowed(newGameState)){
        LOGGER.info("Statechange is not allowed");
      }
      else{
        this.gameState = newGameState;
      }
    }
  }

  private boolean isStateAllowed(GameState newGameState) {
    switch (gameState){
      case PURCHASE:
      case UNINSTALL:
        return newGameState == DOWNLOAD;
      case DOWNLOAD: return newGameState == INSTALL;
      case INSTALL: return newGameState == START || newGameState == UNINSTALL;
      case START: return newGameState == PLAY;
      case PLAY: return newGameState == UPDATE;
      case UPDATE: return newGameState == UNINSTALL || newGameState == START;
    }

    return false;
  }

  public void process(){
    this.gameState.getState().process();
  }
}
