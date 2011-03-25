/*
 * Copyright 2007-2011 VTT Biotechnology
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
package guineu.modules.statistics.Ttest;

import guineu.data.Dataset;
import guineu.main.GuineuCore;
import guineu.util.dialogs.ExitCode;
import java.util.logging.Logger;
import javax.swing.JDialog;

/**
 *
 * @author  SCSANDRA
 */
public class TtestDataDialog extends JDialog {

    private Logger logger = Logger.getLogger(this.getClass().getName());
    private Dataset dataset;
    private TtestDataModel group1, group2, from;
    private ExitCode exit = ExitCode.UNKNOWN;

    /** Creates new form TtestDataDialog */
    public TtestDataDialog(Dataset dataset) {
        super(GuineuCore.getDesktop().getMainFrame(),
                "Please select a experiment groups to do the t-test...", true);

        logger.finest("Displaying experiment open dialog");
        this.dataset = dataset;
        initComponents();

        for (String parameters : dataset.getParametersName()) {
            if (!parameters.equals("Samples")) {
                this.jComboBox1.addItem(parameters);
            }
        }

        try {
            this.from = new TtestDataModel("Experiment Names");
            this.group1 = new TtestDataModel("Group1 - Experiment Names");
            this.group2 = new TtestDataModel("Group2 - Experiment Names");
            this.jTablefrom.setModel(from);
            this.jTablefrom.createToolTip();
            this.jTablegroup1.setModel(group1);
            this.jTablegroup2.setModel(group2);
            this.setValuesTable();
        } catch (Exception exception) {
        }
    }

    public String getParameter() {
        if (this.jCheckBox1.isSelected()) {
            return (String) jComboBox1.getSelectedItem();
        }
        return null;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTablefrom = new javax.swing.JTable();
                jPanel2 = new javax.swing.JPanel();
                jButtonizq2 = new javax.swing.JButton();
                jButtonder2 = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTablegroup1 = new javax.swing.JTable();
                jScrollPane3 = new javax.swing.JScrollPane();
                jTablegroup2 = new javax.swing.JTable();
                jPanel4 = new javax.swing.JPanel();
                jButtonizq1 = new javax.swing.JButton();
                jButtonder1 = new javax.swing.JButton();
                jLabel1 = new javax.swing.JLabel();
                jPanel5 = new javax.swing.JPanel();
                jCheckBox1 = new javax.swing.JCheckBox();
                jComboBox1 = new javax.swing.JComboBox();
                jPanel3 = new javax.swing.JPanel();
                jButtonOK = new javax.swing.JButton();
                jButtonClose = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jTablefrom.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "Experiment Names"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.String.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                jTablefrom.setShowHorizontalLines(false);
                jScrollPane1.setViewportView(jTablefrom);

                jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

                jButtonizq2.setText(">>");
                jButtonizq2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonizq2ActionPerformed(evt);
                        }
                });
                jPanel2.add(jButtonizq2);

                jButtonder2.setText("<<");
                jButtonder2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonder2ActionPerformed(evt);
                        }
                });
                jPanel2.add(jButtonder2);

                jTablegroup1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "Group 1 - Experiment Name"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.String.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                jTablegroup1.setShowHorizontalLines(false);
                jScrollPane2.setViewportView(jTablegroup1);

                jTablegroup2.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "Group 2 - Experiment Name"
                        }
                ) {
                        Class[] types = new Class [] {
                                java.lang.String.class
                        };
                        boolean[] canEdit = new boolean [] {
                                false
                        };

                        public Class getColumnClass(int columnIndex) {
                                return types [columnIndex];
                        }

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                jTablegroup2.setShowHorizontalLines(false);
                jScrollPane3.setViewportView(jTablegroup2);

                jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.PAGE_AXIS));

                jButtonizq1.setText(">>");
                jButtonizq1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonizq1ActionPerformed(evt);
                        }
                });
                jPanel4.add(jButtonizq1);

                jButtonder1.setText("<<");
                jButtonder1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonder1ActionPerformed(evt);
                        }
                });
                jPanel4.add(jButtonder1);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane3, 0, 0, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
                                .addContainerGap())
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(238, 238, 238)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(31, Short.MAX_VALUE))
                );

                jLabel1.setText("Select the groups of experiments");

                jCheckBox1.setText("Use Parameters");
                jPanel5.add(jCheckBox1);

                jPanel5.add(jComboBox1);

                jButtonOK.setText(" Ok ");
                jButtonOK.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonOKActionPerformed(evt);
                        }
                });

                jButtonClose.setText("Cancel");
                jButtonClose.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonCloseActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jButtonOK)
                                .addGap(5, 5, 5)
                                .addComponent(jButtonClose))
                );
                jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonOK)
                                        .addComponent(jButtonClose))
                                .addContainerGap(16, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(730, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(173, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents
    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        exit = ExitCode.OK;
        dispose();
}//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        exit = ExitCode.CANCEL;
        dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonizq2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonizq2ActionPerformed
        int[] selRows = this.jTablefrom.getSelectedRows();
        for (int i = 0; i < selRows.length; i++) {
            if (!this.from.getValueAt(selRows[i], 0).isEmpty()) {
                this.group2.addRows((String) this.from.getValueAt(selRows[i], 0));
                this.from.removeRow(selRows[i]);
            }
        }
        this.from.reconstruct();
        this.jTablefrom.revalidate();
        this.jTablegroup2.revalidate();
}//GEN-LAST:event_jButtonizq2ActionPerformed

    private void jButtonder2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonder2ActionPerformed
        int[] selRows = this.jTablegroup2.getSelectedRows();
        for (int i = 0; i < selRows.length; i++) {
            if (!this.group2.getValueAt(selRows[i], 0).isEmpty()) {
                this.from.addRows((String) this.group2.getValueAt(selRows[i], 0));
                this.group2.removeRow(selRows[i]);
            }
        }
        this.group2.reconstruct();
        this.jTablefrom.revalidate();
        this.jTablegroup2.revalidate();
}//GEN-LAST:event_jButtonder2ActionPerformed

    private void jButtonizq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonizq1ActionPerformed
        int[] selRows = this.jTablefrom.getSelectedRows();
        for (int i = 0; i < selRows.length; i++) {
            if (!this.from.getValueAt(selRows[i], 0).isEmpty()) {
                this.group1.addRows((String) this.from.getValueAt(selRows[i], 0));
                this.from.removeRow(selRows[i]);
            }
        }
        this.from.reconstruct();
        this.jTablefrom.revalidate();
        this.jTablegroup1.revalidate();
    }//GEN-LAST:event_jButtonizq1ActionPerformed

    private void jButtonder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonder1ActionPerformed
        int[] selRows = this.jTablegroup1.getSelectedRows();
        for (int i = 0; i < selRows.length; i++) {
            if (!this.group1.getValueAt(selRows[i], 0).isEmpty()) {
                this.from.addRows((String) this.group1.getValueAt(selRows[i], 0));
                this.group1.removeRow(selRows[i]);
            }
        }
        this.group1.reconstruct();
        this.jTablefrom.revalidate();
        this.jTablegroup1.revalidate();
    }//GEN-LAST:event_jButtonder1ActionPerformed

    public ExitCode getExitCode() {
        return exit;
    }

    public String[] getGroup1() {
        String[] sgroup1 = new String[this.jTablegroup1.getRowCount()];
        for (int i = 0; i < this.jTablegroup1.getRowCount(); i++) {
            sgroup1[i] = this.jTablegroup1.getValueAt(i, 0).toString();
        }
        return sgroup1;
    }

    public String[] getGroup2() {
        String[] sgroup2 = new String[this.jTablegroup2.getRowCount()];
        for (int i = 0; i < this.jTablegroup2.getRowCount(); i++) {
            sgroup2[i] = this.jTablegroup2.getValueAt(i, 0).toString();
        }
        return sgroup2;
    }
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButtonClose;
        private javax.swing.JButton jButtonOK;
        private javax.swing.JButton jButtonder1;
        private javax.swing.JButton jButtonder2;
        private javax.swing.JButton jButtonizq1;
        private javax.swing.JButton jButtonizq2;
        private javax.swing.JCheckBox jCheckBox1;
        private javax.swing.JComboBox jComboBox1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JPanel jPanel4;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JTable jTablefrom;
        private javax.swing.JTable jTablegroup1;
        private javax.swing.JTable jTablegroup2;
        // End of variables declaration//GEN-END:variables

    private void setValuesTable() {
        for (String experimentName : dataset.getAllColumnNames()) {
            this.from.addRows(experimentName);
        }
    }
}
