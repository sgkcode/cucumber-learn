package com.github.sgkcode.hooks;

import com.github.sgkcode.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHook {

  @Before
  public void setupDriver() {
    DriverManager.setupDriver();
  }

  @After
  public void closeDriver() {
    DriverManager.closeDriver();
  }
}
