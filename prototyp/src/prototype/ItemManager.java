package prototype;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ItemManager {

  private Map<String, Item> itemMap = new HashMap<>();

  private static ItemManager INSTANCE = null;

  protected ItemManager() {
    //load the config File and make the map for the swords!

    try {
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();

      Document xml = dbBuilder.parse(new File("config.xml"));
      xml.getDocumentElement().normalize();

      NodeList swordNodes = xml.getElementsByTagName("items").item(0).getChildNodes();

      for (int i = 0; i < swordNodes.getLength(); i++) {
        Node node = swordNodes.item(i);

        if (node.getNodeType() == Node.ELEMENT_NODE) {
          Element el = (Element) node;

          Sword sword = Sword.createFromXML(el);
          itemMap.put(sword.getObjectName(), sword);
        }
      }

      /**
       * For extension add parsing further items..
       */

    } catch (ParserConfigurationException e) {
      System.err.println("Something went wrong when trying to parse : " + e.getMessage());
    } catch (IOException e) {
      System.err.println("Something went wrong when trying to read File: " + e.getMessage());
    } catch (SAXException e) {
      System.err.println("Something went wrong with SAX-Parsing : " + e.getMessage());
    }

    //lade das config file
    // für jedes sword im file ein neues prototype anlegen und mit werten aus dem file befüllen
    // und den name und die referenz in die Map speichern
  }

  public static ItemManager getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ItemManager();
    }

    return INSTANCE;
  }

  public <T> T cloneObject(Class<T> clazz, String key) {
    if (itemMap.containsKey(key)) {
      return (T) itemMap.get(key).clone();
    } else {
      return null;
    }
  }

  public void printMap() {
    itemMap.forEach((k, v) -> {
      System.out.println(String.format("Key : %s", k));
      System.out.println(String.format("Value : %s", v));
    });
  }
}
