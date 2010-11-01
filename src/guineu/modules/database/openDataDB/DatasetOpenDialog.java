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
import guineu.data.DatasetType;
import guineu.data.impl.datasets.SimpleGCGCDataset;
import guineu.data.impl.datasets.SimpleLCMSDataset;
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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
    private List<newParameterDialog> parameters;
    private List<Dataset> datasets;
    private JTree tree;
    private Hashtable<CheckNode, String[]> nodeTable;
    private Hashtable<CheckNode, NodeInfo> nodeInfoTable;

    /** Creates new form DatasetOpenDialog */
    public DatasetOpenDialog() {
        super(GuineuCore.getDesktop().getMainFrame(), "Database...", true);
        initComponents();
        nodeTable = new Hashtable<CheckNode, String[]>();
        nodeInfoTable = new Hashtable<CheckNode, NodeInfo>();
        parameters = new ArrayList<newParameterDialog>();
        datasets = new ArrayList<Dataset>();
        tree = createTree();

    }

    ExitCode getExitCode() {
        return exitCode;
    }

    /** This platform is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this platform is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
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

        logicCB.setModel(new javax.swing.DefaultComboBoxModel(new String[]{" ", "AND", "OR", "NOT"}));
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
    }// </editor-fold>

    /**
     * Return the generated data sets.
     *
     * @return A list of data sets
     */
    public List<Dataset> getDatasets() {
        return datasets;
    }

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    public boolean combineDataset() {
        return this.combineDatasetsCB.isSelected();
    }

    /**
     * Creates the datasets from selected nodes. Each selected node can be the name of one sample, or
     * the name of a complete data set.
     *
     * @param node Node from the tree
     */
    private void createDataset(CheckNode node) {
        Dataset dataset = null;

        String[] data = nodeTable.get(node);
        try {
            if (data != null) {

                // Creates a new data set
                if (data[2].contains("LC-MS")) {
                    dataset = new SimpleLCMSDataset(data[1]);
                    dataset.setType(DatasetType.LCMS);
                } else if (data[2].contains("GCxGC-MS")) {
                    dataset = new SimpleGCGCDataset(data[1]);
                    dataset.setType(DatasetType.GCGCTOF);
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
                        }
                    }
                }

                // If the complete dataset is selected
                if (node.isSelected && dataset.getNumberCols() == 0) {
                    try {
                        DataBase db = new OracleRetrievement();
                        Vector<String> sampleNames = db.getSampleNames(Integer.valueOf(data[0]));
                        for (String sampleName : sampleNames) {
                            dataset.addColumnName(sampleName);
                        }

                    } catch (Exception exception) {
                    }
                }

                if (dataset.getNumberCols() > 0) {
                    datasets.add(dataset);
                    return;
                }

            }

            // If the complete study is selected
            if (node.isSelected && node.getLevel() == 1) {
                for (int i = 0; i < node.getChildCount(); i++) {
                    createDataset((CheckNode) node.getChildAt(i));
                }
            }


        } catch (Exception e) {
        }

    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        exitCode = ExitCode.CANCEL;
        dispose();
    }

    private void addParameterButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    /**
     * Applies every rule to select or deselect nodes. First open the children of all the datasets
     * from the database. It could take some time and can be more sofisticated in the future.
     */
    private void applyRulesButtonActionPerformed(java.awt.event.ActionEvent evt) {

        for (int i = 0; i < tree.getRowCount(); i++) {
            TreePath path = tree.getPathForRow(i);
            tree.expandPath(path);
            if (path != null) {
                CheckNode node = (CheckNode) path.getLastPathComponent();
                addChildren(node);
            }

        }

        for (int i = 2; i < tree.getRowCount(); i++) {
            TreePath path = tree.getPathForRow(i);
            tree.collapsePath(path);
        }
        Set<CheckNode> set = this.nodeInfoTable.keySet();

        Iterator<CheckNode> itr = set.iterator();
        while (itr.hasNext()) {
            CheckNode node = itr.next();
            setRule(node);
        }

        // Sets parent selection depending on the children
        TreePath path = tree.getPathForRow(0);
        if (path != null) {
            CheckNode parentNode = (CheckNode) path.getPathComponent(0);
            setRecursiveSelection(parentNode);
        }


    }

    /**
     * Deselects all the nodes which don't have any selected child.
     *
     * @param node Parent node
     * @return True when any children is selected
     */
    private boolean setRecursiveSelection(CheckNode node) {
        boolean selection = false;
        boolean finalSelection = false;
        for (int i = 0; i < node.getChildCount(); i++) {
            CheckNode child = (CheckNode) node.getChildAt(i);
            if (child.isSelected) {
                selection = setRecursiveSelection(child);
                if (selection) {
                    finalSelection = true;
                }
            }
        }

        if (node.getChildCount() == 0) {
            return node.isSelected();
        } else if (node.getChildCount() > 0) {
            if (!finalSelection) {
                node.setSelectedOnlyMe(false);
                return false;
            } else {
                node.setSelectedOnlyMe(true);
                return true;
            }
        }
        return selection;
    }

    /**
     * Selects or deselects the parents of the node.
     *
     * @param node node
     * @param selection selection
     */
    private void setParentSelection(CheckNode node) {
        int level = node.getLevel();
        CheckNode parent = (CheckNode) node.getParent();
        parent.setSelectedOnlyMe(true);
        for (int i = 0; i < level - 1; i++) {
            parent = (CheckNode) parent.getParent();
            parent.setSelectedOnlyMe(true);
        }
    }

    /**
     * Decides the selection setting of the node depending on the the "logic"
     * string in the "rule".
     *
     * @param node CheckNode
     * @param logic Logic string: "AND", "OR", "NOT"
     */
    private void setLogic(CheckNode node, String logic, boolean lastStatus, boolean status) {
        if (logic.contains("OR")) {
            if (lastStatus || status) {
                node.setSelected(true);
                setParentSelection(node);
            } else {
                node.setSelected(false);
            }
        } else if (logic.contains("NOT")) {
            if (status) {
                node.setSelected(false);
            }
        } else if (logic.contains("AND")) {
            if (lastStatus && status) {
                node.setSelected(true);
                setParentSelection(node);
            } else {
                node.setSelected(false);
            }
        } else {
            if (status) {
                node.setSelected(true);
                setParentSelection(node);
            }
        }

    }

    /**
     * Sets the selection setting of each node depending on the parameters of one
     * rule.
     *
     * @param type Type of the parameter that is going to be checked
     * @param value Value of the parameter
     * @param logic Logic string: "AND", "OR", "NOT"
     */
    private void setRule(CheckNode node) {
        NodeInfo info = this.nodeInfoTable.get(node);

        for (newParameterDialog rule : parameters) {
            boolean lastStatus = node.isSelected();
            boolean status = false;
            Type ruleType = null;
            String strType = rule.getType();
            for (Type type : Type.values()) {
                if (type.toString().equals(strType)) {
                    ruleType = type;

                }
            }
            if (rule.getValue() != null) {
                try {
                    switch (ruleType) {

                        case Platform:
                            if (info.platform != null && info.platform.equals(rule.getValue())) {
                                status = true;
                            } else {
                                status = false;
                            }
                            break;
                        case Tissue:
                            if (info.tissue != null && info.tissue.equals(rule.getValue())) {
                                status = true;
                            } else {
                                status = false;
                            }
                            break;
                        case Organism:
                            if (info.organism != null && info.organism.equals(rule.getValue())) {
                                status = true;
                            } else {
                                status = false;
                            }
                            break;
                        case Subtype:
                            if (info.phenotype != null && info.phenotype.equals(rule.getValue())) {
                                status = true;
                            } else {
                                status = false;
                            }
                            break;
                        case Contain:
                            if (info.toString() != null && node.toString().equals(rule.getValue())) {
                                status = true;
                            } else {
                                status = false;
                            }
                            break;
                    }
                    setLogic(node, rule.getLogic(), lastStatus, status);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }

    }

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

    /**
     * Creates a tree with the studies and their correspondents data sets.
     * The information is taken from the database.
     *
     * @return New tree
     */
    private JTree createTree() {
        DataBase db = new OracleRetrievement();
        String rows[][] = db.getDatasetInfo();
        String rootName = "Studies";
        CheckNode rootNode = new CheckNode(rootName);


        List<String[]> studies = db.getStudiesInfo();

        for (String[] study : studies) {
            CheckNode stNode = new CheckNode(study[0] + " - " + study[1]);
            for (String[] row : rows) {
                if (row[6].equals(study[0])) {
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

        return tree;
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
                addChildren(node);
            }
        }
    }

    /**
     * Adds the "samples" node for the selected "data set" node. The information to
     * create them is taken from the database.
     *
     * @param node "data set" node
     */
    private void addChildren(CheckNode node) {

        String[] data = nodeTable.get(node);
        if (node.getChildCount() == 0 && data != null) {
            try {
                DataBase db = new OracleRetrievement();
                Vector<String> sampleNames = db.getSampleNames(Integer.valueOf(data[0]));
                for (String sampleName : sampleNames) {
                    String[] param = db.getParameters(sampleName);

                    CheckNode childNode = new CheckNode(sampleName, false, true, 0);
                    node.add(childNode);

                    setParameters(childNode, param, data);
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        ((DefaultTreeModel) tree.getModel()).nodeChanged(node);
        tree.revalidate();
        tree.repaint();
    }

    /**
     * Sets the characteristics of each node. It will be used to check the rules to
     * do the filtering.
     *
     * @param childNode Node
     * @param parameters Parameters of the sample taken from the database
     * @param data Parameters of the data set taken from the database         *
     */
    private void setParameters(CheckNode childNode, String[] parameters, String[] data) {
        try {
            NodeInfo info = new NodeInfo();
            info.organism = parameters[3];
            info.platform = data[2];
            info.tissue = parameters[2];
            info.phenotype = "control";
            this.nodeInfoTable.put(childNode, info);
        } catch (NullPointerException exception) {
            //exception.printStackTrace();
        }
    }

    enum Type {

        Platform, Tissue, Organism, Subtype, Contain;
    }

    class NodeInfo {

        String tissue;
        String organism;
        String platform;
        String phenotype;
    }
    // Variables declaration - do not modify
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
    // End of variables declaration
}
