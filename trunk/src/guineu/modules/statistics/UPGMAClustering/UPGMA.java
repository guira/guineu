/*
 * Copyright 2007-2008 VTT Biotechnology
 * This file is part of Guineu.
 *
 * Guineu is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * Guineu is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Guineu; if not, write to the Free Software Foundation, Inc., 51 Franklin St,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */

package guineu.modules.statistics.UPGMAClustering;

import guineu.data.Dataset;
import guineu.data.ParameterSet;
import guineu.data.impl.SimpleLCMSDataset;
import guineu.desktop.Desktop;
import guineu.desktop.GuineuMenu;
import guineu.desktop.impl.DesktopParameters;
import guineu.main.GuineuCore;
import guineu.main.GuineuModule;
import guineu.taskcontrol.Task;
import guineu.taskcontrol.TaskGroup;
import guineu.taskcontrol.TaskGroupListener;
import guineu.taskcontrol.TaskListener;
import guineu.util.dialogs.ExitCode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.logging.Logger;

/**
 *
 * @author scsandra
 */
public class UPGMA implements GuineuModule, TaskListener, ActionListener {
   private Logger logger = Logger.getLogger(this.getClass().getName());
 

    private Desktop desktop;
    private SimpleLCMSDataset dataset;
    private String[] group1, group2;
    
    public void initModule() {

        this.desktop = GuineuCore.getDesktop();         
        desktop.addMenuItem(GuineuMenu.STATISTICS, "UPGMA Clustering..",
                "TODO write description", KeyEvent.VK_U, this, null, "icons/help.png");

    }

    
    public void taskStarted(Task task) {
        logger.info("Running UPGMA Clustering");
    }

    public void taskFinished(Task task) {
        if (task.getStatus() == Task.TaskStatus.FINISHED) {
            logger.info("Finished UPGMA Clustering on "
                    + ((UPGMATask) task).getTaskDescription());
        }

        if (task.getStatus() == Task.TaskStatus.ERROR) {

            String msg = "Error while UPGMA Clustering on .. "
                    + ((UPGMATask) task).getErrorMessage();
            logger.severe(msg);
            desktop.displayErrorMessage(msg);

        }
    }

    public void actionPerformed(ActionEvent e) {
        ExitCode exitCode = setupParameters();
        if (exitCode != ExitCode.OK)
            return;

        runModule(null);
    }

    public ExitCode setupParameters() {
        try{
            Dataset[] datasets = desktop.getSelectedDataFiles();
            dataset = (SimpleLCMSDataset) datasets[0];
            UPGMADataDialog dialog = new UPGMADataDialog(dataset);
            dialog.setVisible(true);
            group1 = dialog.getGroup1();
            group2 = dialog.getGroup2();
            return dialog.getExitCode();
        }catch(Exception exception){
            return ExitCode.CANCEL;
        }
    }

    public ParameterSet getParameterSet() {
        return null;
    }

    public void setParameters(ParameterSet parameterValues) {
        
    }
    
    public String toString() {
        return "UPGMA Clustering";
    }

    public TaskGroup runModule( TaskGroupListener taskGroupListener) {
        
        // prepare a new group of tasks
       
        Task tasks[] = new UPGMATask[1];       
        tasks[0] = new UPGMATask(group1, dataset, desktop);

        TaskGroup newGroup = new TaskGroup(tasks, this, taskGroupListener);

        // start the group
        newGroup.start();

        return newGroup;
       

    }
    
  

}