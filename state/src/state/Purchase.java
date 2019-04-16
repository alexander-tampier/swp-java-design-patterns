package state;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Purchase implements State{

  private static final Logger LOGGER = Logger.getLogger(Purchase.class.getName());

  @Override
  public void process() {
    LOGGER.info("GameState will be purchased");
  }
}
