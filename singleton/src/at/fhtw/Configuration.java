package at.fhtw;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Early Loading Singleton
 */
public class Configuration {

  // public INSTANCE
  public static Configuration INSTANCE = null;

  private static final String PROPERTY_ENVIRONMENT = "configuration.properties";

  private Properties properties;

  /**
   * sub part of Eager initialization. The only difference is object is
   * created in a static block so that we can have access on its creation,
   * like exception handling
   */
  static {
    // static block to initialize INSTANCE
    INSTANCE = new Configuration();
  }

  /**
   * Loads the properties at all into java environment
   */
  private Configuration() {
    properties = new Properties();

    try (InputStreamReader reader = new InputStreamReader(Configuration.class.getClassLoader()
        .getResourceAsStream(PROPERTY_ENVIRONMENT))) {
      properties.load(reader);
    } catch (IOException e) {
      System.out.println("Configuration failed loading : " + e.getMessage());
    }
  }

  /**
   * get configuration property
   *
   * @param p property name
   * @return property value, if any, null else
   */
  public String getProperty(String p) {
    return properties.getProperty(p);
  }

}

