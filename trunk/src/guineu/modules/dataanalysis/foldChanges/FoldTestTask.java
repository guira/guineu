/*
 * Copyright 2007-2012 VTT Biotechnology
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
package guineu.modules.dataanalysis.foldChanges;

import guineu.data.PeakListRow;
import guineu.data.Dataset;
import guineu.taskcontrol.AbstractTask;
import guineu.taskcontrol.TaskStatus;
import guineu.util.GUIUtils;
import guineu.util.components.FileUtils;
import java.util.Vector;
import org.apache.commons.math.MathException;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

/**
 *
 * @author scsandra
 */
public class FoldTestTask extends AbstractTask {

        private double progress = 0.0f;
        private String[] group1, group2;
        private Dataset dataset;
        private String parameter;

        public FoldTestTask(String[] group1, String[] group2, Dataset dataset, String parameter) {
                this.group1 = group1;
                this.group2 = group2;
                this.dataset = dataset;
                this.parameter = parameter;
        }

        public String getTaskDescription() {
                return "Fold Changes... ";
        }

        public double getFinishedPercentage() {
                return progress;
        }

        public void cancel() {
                setStatus(TaskStatus.CANCELED);
        }

        public void run() {
                try {
                        setStatus(TaskStatus.PROCESSING);
                        double[] t = new double[dataset.getNumberRows()];
                        for (int i = 0; i < dataset.getNumberRows(); i++) {
                                t[i] = this.Foldtest(i);
                        }

                        Dataset newDataset = FileUtils.getDataset(dataset, "Fold changes - ");
                        progress = 0.3f;
                        newDataset.addColumnName("Fold changes");
                        int cont = 0;
                        for (PeakListRow row : dataset.getRows()) {
                                PeakListRow newRow = row.clone();
                                newRow.setPeak("Fold changes", t[cont++]);
                                newDataset.addRow(newRow);
                        }
                        progress = 0.5f;

                        GUIUtils.showNewTable(newDataset, true);

                        progress = 1f;
                        setStatus(TaskStatus.FINISHED);

                } catch (Exception e) {
                        setStatus(TaskStatus.ERROR);
                        errorMessage = e.toString();
                        return;
                }
        }

        public double Foldtest(int mol) throws IllegalArgumentException, MathException {
                DescriptiveStatistics stats1 = new DescriptiveStatistics();
                DescriptiveStatistics stats2 = new DescriptiveStatistics();

                String parameter1 = "";

                if (parameter == null) {
                        for (int i = 0; i < group1.length; i++) {
                                try {
                                        double value = (Double) this.dataset.getRow(mol).getPeak(group1[i]);
                                        // if (value > 0) {
                                        stats1.addValue(value);
                                        // }
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                        for (int i = 0; i < group2.length; i++) {
                                try {
                                        double value = (Double) this.dataset.getRow(mol).getPeak(group2[i]);
                                        //if (value > 0) {
                                        stats2.addValue(value);
                                        // }
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }

                } else {
                        try {
                                // Determine groups for selected raw data files
                                Vector<String> availableParameterValues = dataset.getParameterAvailableValues(parameter);

                                int numberOfGroups = availableParameterValues.size();

                                if (numberOfGroups > 1) {
                                        parameter1 = availableParameterValues.firstElement();
                                        String parameter2 = availableParameterValues.elementAt(1);

                                        for (String sampleName : dataset.getAllColumnNames()) {
                                                if (dataset.getParametersValue(sampleName, parameter) != null && dataset.getParametersValue(sampleName, parameter).equals(parameter1)) {
                                                        stats1.addValue((Double) this.dataset.getRow(mol).getPeak(sampleName));
                                                } else if (dataset.getParametersValue(sampleName, parameter) != null && dataset.getParametersValue(sampleName, parameter).equals(parameter2)) {
                                                        stats2.addValue((Double) this.dataset.getRow(mol).getPeak(sampleName));
                                                }
                                        }
                                } else {
                                        return -1;
                                }

                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }

                if (stats1.getN() > 0 && stats2.getN() > 0) {
                        /*double[] sortValues1 = stats1.getSortedValues();
                        double[] sortValues2 = stats2.getSortedValues();

                        return sortValues1[((int) stats1.getN() / 2)] / sortValues2[((int) stats2.getN() / 2)];*/
                        return stats1.getMean() / stats2.getMean();
                } else {
                        return 0;
                }
        }
}