package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.command.ICompoundCommand;
import edu.kis.powp.jobs2d.command.manager.DriverCommandManager;
import edu.kis.powp.jobs2d.command.transformation.CommandVisitorTransformation;
import edu.kis.powp.jobs2d.command.transformation.CommandVisitorTransformationScale;
import edu.kis.powp.jobs2d.features.CommandsFeature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectCommandTransformationScaleOptionListener implements ActionListener {
    private double scaleFactorX;
    private double scaleFactorY;

    public SelectCommandTransformationScaleOptionListener (double scaleFactorX, double scaleFactorY) {
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DriverCommandManager driverCommandManager = CommandsFeature.getDriverCommandManager();

        CommandVisitorTransformation commandVisitorTransformation = new CommandVisitorTransformationScale(this.scaleFactorX, this.scaleFactorY);
        driverCommandManager.getCurrentCommand().accept(commandVisitorTransformation);
        ICompoundCommand iCompoundCommand = commandVisitorTransformation.getCompoundCommand();

        driverCommandManager.setCurrentCommand(iCompoundCommand);
    }
}
