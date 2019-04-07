import prototype.ItemManager;
import prototype.Sword;

public class Main {

  public static void main(String[] args) {
    ItemManager itemManager = ItemManager.getInstance();
    itemManager.printMap();
    Sword longSword = itemManager.cloneObject(Sword.class, "long_sword");
    Sword shortSword = itemManager.cloneObject(Sword.class, "short_sword");
    Sword knife = itemManager.cloneObject(Sword.class, "knife");
    System.out.println("\nCloned items:");
    System.out.println(longSword);
    System.out.println(shortSword);
    System.out.println(knife);
  }
}
