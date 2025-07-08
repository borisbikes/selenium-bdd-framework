package com.epam.automation.pages;

import com.epam.automation.utilities.GuiUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage
{
	protected WebDriver driver;
	protected GuiUtils guiUtils;
	protected static Logger log = LogManager.getRootLogger();

	protected abstract AbstractPage openPage();
	public static final int WAIT_TIMEOUT_SECONDS = 10;

	protected AbstractPage(WebDriver driver) {
		this.driver = driver;
		this.guiUtils = new GuiUtils(driver);
	}
}
