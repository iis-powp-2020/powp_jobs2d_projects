package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectDriverMenuOptionListener implements ActionListener {
	private DriverManager driverManager;
	private Job2dDriver driver = null;

	public SelectDriverMenuOptionListener(Job2dDriver driver, DriverManager driverManager) {
		this.driverManager = driverManager;
		this.driver = driver;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		driverManager.setCurrentDriver(driver);
	}

	public Job2dDriver getDriver() {
		return driver;
	}

	public void setDriver(Job2dDriver driver) {
		this.driver = driver;
	}
}
