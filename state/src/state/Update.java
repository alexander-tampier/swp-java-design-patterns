package state;

import java.util.logging.Logger;

public class Update implements State {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  @Override
  public void process() {
    LOGGER.info("GameState will be updated");
  }
}
