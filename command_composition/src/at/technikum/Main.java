package at.technikum;

import at.technikum.command.Borrow;
import at.technikum.command.Lend;
import at.technikum.command.LocalSteam;
import at.technikum.composition.Download;
import at.technikum.composition.Install;
import at.technikum.composition.OneClick;
import at.technikum.command.Order;
import at.technikum.command.Reclaim;
import at.technikum.command.Return;
import at.technikum.composition.Purchase;
import at.technikum.composition.ReadyForPlaying;
import at.technikum.composition.Update;
import at.technikum.dto.Gender;
import at.technikum.dto.Person;
import at.technikum.state.Game;
import at.technikum.state.GameControl;

public class Main {

  public static void main(String[] args) {
    Person atam = new Person.Builder(Gender.MALE, "Alexander", "Tampier")
        .setTelephone("+436765538923")
        .setState("Austria")
        .setCity("Vienna")
        .build();

    GameControl leagueOfLegends = new GameControl(Game.LEAGUE_OF_LEGENDS);
    GameControl fortnite = new GameControl(Game.FORTNITE);
    GameControl worldOfWarcraft = new GameControl(Game.WORLD_OF_WARCRAFT);

    /**
     * State pattern - change state
     */

    System.out.println("-----------------");
    System.out.println("Change states");
    System.out.println("-----------------");

    fortnite.purchase(atam);
    fortnite.download();
    fortnite.install();
    fortnite.update();
    fortnite.readyForPlaying();
    fortnite.start();
    fortnite.play();
    fortnite.readyForPlaying();

    /**
     * Composition Markos
     */
    OneClick makros = new OneClick(worldOfWarcraft);
    makros.setName("Makros");

    OneClick makro1 = new OneClick(worldOfWarcraft);
    makro1.setName("Makro1");
    makro1.addChild(new Purchase(worldOfWarcraft, atam));
    makro1.addChild(new Download(worldOfWarcraft));
    makro1.addChild(new Install(worldOfWarcraft));
    makro1.addChild(new Update(worldOfWarcraft));
    makro1.addChild(new ReadyForPlaying(worldOfWarcraft));

    makros.addChild(makro1);

    System.out.println("-----------------");
    System.out.println("Composition - OneClick Buy");
    System.out.println("-----------------");
    makros.execute();

    /**
     * Command - Borrow, Lend, Reclaim
     */
    LocalSteam localSteam = new LocalSteam();

    // Order Scenario 1 - Borrow from friend
    Order borrowFromFriend = new Borrow(leagueOfLegends);
    Order returnToFriend = new Return(leagueOfLegends);

    // Order Scenario 2 - Lend to friend
    Order lendToFriend = new Lend(worldOfWarcraft);
    Order reclaimFromFriend = new Reclaim(worldOfWarcraft);


    System.out.println("-----------------");
    System.out.println("Command - Borrow and return");
    System.out.println("-----------------");

    localSteam.addOrder(borrowFromFriend);
    localSteam.addOrder(returnToFriend);
    localSteam.placeOrders();

    System.out.println("-----------------");
    System.out.println("Command - Lend and reclaim");
    System.out.println("-----------------");

    localSteam.addOrder(lendToFriend);
    localSteam.addOrder(reclaimFromFriend);
    localSteam.placeOrders();

  }
}
