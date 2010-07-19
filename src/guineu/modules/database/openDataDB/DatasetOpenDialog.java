/*
 * Copyright 2007-2010 VTT Biotechnology
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
package guineu.modules.database.openDataDB;

import guineu.data.Dataset;
import guineu.data.impl.SimpleGCGCDataset;
import guineu.data.impl.SimpleLCMSDataset;
import guineu.database.retrieve.impl.OracleRetrievement;
import guineu.database.retrieve.DataBase;
import guineu.main.GuineuCore;
import guineu.util.dialogs.ExitCode;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author scsandra
 */
public class DatasetOpenDialog extends JDialog implements ActionListener {

        private ExitCode exitCode = ExitCode.UNKNOWN;
        private int size = 50;
        private List<Rule> rules;
        private List<newParameterDialog> parameters;
        private List<Dataset> datasets;
        private JTree tree;
        Hashtable<CheckNode, String[]> nodeTable;

        /** Creates new form DatasetOpenDialog */
        public DatasetOpenDialog() {
                super(GuineuCore.getDesktop().getMainFrame(), "Database...", true);
                initComponents();
                nodeTable = new Hashtable<CheckNode, String[]>();

                newParameterDialog parameter = new newParameterDialog();
                this.parameterContiner.add(parameter);
                parameter.removeButton.setVisible(false);
                parameter.setVisible(true);
                rules = new ArrayList<Rule>();
                parameters = new ArrayList<newParameterDialog>();
                datasets = new ArrayList<Dataset>();
                this.createTree();

        }

        ExitCode getExitCode() {
                return exitCode;
        }

        /** This method is called from within the constructor to
         * initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logicCB = new javax.swing.JComboBox();
        addParameterButton = new javax.swing.JButton();
        applyRulesButton = new javax.swing.JButton();
        parameterScroll = new javax.swing.JScrollPane();
        parameterContiner = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        SPResults = new javax.swing.JScrollPane();
        buttonsPanel = new javax.swing.JPanel();
        combineDatasetsCB = new javax.swing.JCheckBox();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(201, 700));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setPreferredSize(new java.awt.Dimension(120, 46));

        jLabel1.setText("Add parameter:");
        jPanel1.add(jLabel1);

        logicCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AND", "OR", "NOT", "XOR" }));
        logicCB.setPreferredSize(new java.awt.Dimension(100, 24));
        jPanel1.add(logicCB);

        addParameterButton.setText("Add");
        addParameterButton.setPreferredSize(new java.awt.Dimension(70, 26));
        addParameterButton.setRequestFocusEnabled(false);
        addParameterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addParameterButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addParameterButton);

        applyRulesButton.setText("Apply Rules");
        applyRulesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyRulesButtonActionPerformed(evt);
            }
        });
        jPanel1.add(applyRulesButton);

        getContentPane().add(jPanel1);

        parameterScroll.setBackground(new java.awt.Color(253, 251, 251));
        parameterScroll.setPreferredSize(new java.awt.Dimension(100, 200));

        parameterContiner.setBackground(new java.awt.Color(253, 251, 251));
        parameterContiner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        parameterContiner.setPreferredSize(new java.awt.Dimension(100, 24));
        parameterScroll.setViewportView(parameterContiner);

        getContentPane().add(parameterScroll);

        jPanel2.setPreferredSize(new java.awt.Dimension(647, 500));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(SPResults);

        getContentPane().add(jPanel2);

        buttonsPanel.setOpaque(false);
        buttonsPanel.setPreferredSize(new java.awt.Dimension(647, 48));

        combineDatasetsCB.setText("Combine datasets");
        buttonsPanel.add(combineDatasetsCB);

        okButton.setText("OK");
        okButton.setPreferredSize(new java.awt.Dimension(70, 26));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(okButton);

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new java.awt.Dimension(90, 26));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(cancelButton);

        getContentPane().add(buttonsPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

        public List<Dataset> getDatasets() {
                return datasets;
        }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
            if (tree != null) {
                    for (int index = 0; index < tree.getRowCount(); index++) {
                            TreePath path = tree.getPathForRow(index);
                            if (path != null) {
                                    CheckNode node = (CheckNode) path.getLastPathComponent();
                                    if (node != null) {
                                            createDataset(node);
                                    }
                            }
                    }
            }

            exitCode = ExitCode.OK;
            dispose();
    }//GEN-LAST:event_okButtonActionPerformed

        private void createDataset(CheckNode node) {
                Dataset dataset = null;
                //System.out.println("node - " + node.toString());
                String[] data = nodeTable.get(node);
                if (data != null) {
                        try {
                                // Creates a new data set
                                if (data[2].contains("LC-MS")) {
                                        dataset = new SimpleLCMSDataset(data[1]);
                                } else if (data[1].contains("GCxGC-MS")) {
                                        dataset = new SimpleGCGCDataset(data[1]);
                                }

                                // Sets the data set ID
                                dataset.setID(Integer.parseInt(data[0]));

                                // Sets the number of rows
                                dataset.setNumberRows(Integer.parseInt(data[5]));

                                // Sets column names
                                if (node.getChildCount() > 0) {
                                        for (int i = 0; i < node.getChildCount(); i++) {
                                                CheckNode child = (CheckNode) node.getChildAt(i);
                                                if (child.isSelected()) {
                                                        dataset.addColumnName(child.toString());
                                                } else {
                                                        child.setSelected(false);
                                                }
                                        }
                                } else if (node.isSelected) {
                                        try {
                                                DataBase db = new OracleRetrievement();
                                                Vector<String> sampleNames = db.get_samplenames(Integer.valueOf(data[0]));
                                                for (String sampleName : sampleNames) {
                                                        dataset.addColumnName(sampleName);
                                                }

                                        } catch (Exception exception) {
                                        }
                                }
                                System.out.println(dataset.getNumberCols());
                                if (dataset.getNumberCols() > 0) {
                                        datasets.add(dataset);
                                }
                        } catch (Exception e) {
                        }
                }

        }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
            exitCode = ExitCode.CANCEL;
            dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addParameterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addParameterButtonActionPerformed
            newParameterDialog parameter = new newParameterDialog();
            String label = "   " + this.logicCB.getSelectedItem().toString();
            parameter.setLogicLabel(label);
            parameter.removeButton.addActionListener(this);
            this.parameters.add(parameter);
            this.parameterContiner.add(parameter);
            size += 30;
            this.parameterContiner.setPreferredSize(new Dimension(100, size));
            parameter.setVisible(true);
            this.parameterContiner.revalidate();
}//GEN-LAST:event_addParameterButtonActionPerformed

    private void applyRulesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyRulesButtonActionPerformed
            for (newParameterDialog parameter : parameters) {
                    Rule rule = new Rule();
                    rule.type = parameter.getType();
                    rule.value = parameter.getValue();
                    rule.value = parameter.getLogic();
                    rules.add(rule);
            }

}//GEN-LAST:event_applyRulesButtonActionPerformed

        public void actionPerformed(ActionEvent evt) {
                Object source = evt.getSource();
                for (newParameterDialog dialog : this.parameters) {
                        if (source.equals(dialog.removeButton)) {
                                this.parameters.remove(dialog);
                                this.parameterContiner.remove(dialog);
                                this.parameterContiner.revalidate();
                                this.parameterContiner.repaint();
                                break;

                        }
                }

        }

        class Rule {

                String type;
                String value;
                String logic;
        }

        private void createTree() {
                DataBase db = new OracleRetrievement();
                String rows[][] = db.getDatasetInfo();
                String rootName = "Studies";
                CheckNode rootNode = new CheckNode(rootName);


                String[] studies = OracleRetrievement.getStudies();

                for (String study : studies) {
                        CheckNode stNode = new CheckNode(study);
                        for (String[] row : rows) {
                                if (row[6].equals(study)) {
                                        String name = row[1];
                                        CheckNode node = new CheckNode(name);
                                        stNode.add(node);
                                        nodeTable.put(node, row);
                                }
                        }
                        rootNode.add(stNode);
                }


                tree = new JTree(rootNode);
                tree.setCellRenderer(new CheckRenderer());
                tree.getSelectionModel().setSelectionMode(
                        TreeSelectionModel.SINGLE_TREE_SELECTION);
                tree.putClientProperty("JTree.lineStyle", "Angled");
                tree.addMouseListener(new NodeSelectionListener(tree));

                this.SPResults.setViewportView((Component) tree);


        }

        enum Levels {

                STUDIES, DATASETS, SAMPLES
        }

        class NodeSelectionListener extends MouseAdapter {

                JTree tree;

                NodeSelectionListener(JTree tree) {
                        this.tree = tree;
                }

                @Override
                public void mousePressed(MouseEvent e) {
                        int x = e.getX();
                        int y = e.getY();
                        int row = tree.getRowForLocation(x, y);
                        TreePath path = tree.getPathForRow(row);
                        if (path != null) {
                                CheckNode node = (CheckNode) path.getLastPathComponent();

                                boolean isSelected = !(node.isSelected());
                                node.setSelected(isSelected);
                                // if (node.getLevel() == Levels.SAMPLES.ordinal()) {
                                if (node.getChildCount() == 0) {
                                        try {
                                                DataBase db = new OracleRetrievement();
                                                String[] data = nodeTable.get(node);
                                                Vector<String> sampleNames = db.get_samplenames(Integer.valueOf(data[0]));
                                                for (String sampleName : sampleNames) {
                                                        CheckNode childNode = new CheckNode(sampleName, true, true);
                                                        node.add(childNode);
                                                }

                                        } catch (Exception exception) {
                                        }
                                        //  }
                                }
                                ((DefaultTreeModel) tree.getModel()).nodeChanged(node);
                                tree.revalidate();
                                tree.repaint();
                        }
                }
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane SPResults;
    private javax.swing.JButton addParameterButton;
    private javax.swing.JButton applyRulesButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox combineDatasetsCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox logicCB;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel parameterContiner;
    private javax.swing.JScrollPane parameterScroll;
    // End of variables declaration//GEN-END:variables
}
