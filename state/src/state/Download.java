package state;

import java.util.logging.Logger;

public class Download implements State {

  private static final Logger LOGGER = Logger.getLogger(Download.class.getName());

  @Override
  public void process() {
    LOGGER.info("GameState will be downloaded");
  }
}
