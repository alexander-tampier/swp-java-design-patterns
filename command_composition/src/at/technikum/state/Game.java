package at.technikum.state;

public enum Game {
  LEAGUE_OF_LEGENDS("League of Legends"),
  FORTNITE("League of Legends"),
  WORLD_OF_WARCRAFT("World of Warcraft");

  private final String name;

  Game(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
