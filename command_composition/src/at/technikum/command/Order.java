package at.technikum.command;

import at.technikum.state.GameControl;
import java.util.List;

public abstract class Order {
  protected GameControl gameControl;

  public Order(GameControl gameControl) {
    this.gameControl = gameControl;
  }

  public GameControl getGameControl() {
    return gameControl;
  }

  /**
   * Command
   */
  public abstract void execute();
  public abstract void undo();

  /**
   * Composition
   */
  public void addChild(Order order){
  }

  public void removeChild(Order order){
  }

  public void getChild(int index){
  }
}
