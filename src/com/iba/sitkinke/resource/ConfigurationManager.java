package com.iba.sitkinke.resource;

import java.util.ResourceBundle;

public class ConfigurationManager {
  private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

  // класс извлекает информацию из файла resources. properties
  private ConfigurationManager() {
  }

  public static String getProperty(String key) {
    return resourceBundle.getString(key);
  }
}