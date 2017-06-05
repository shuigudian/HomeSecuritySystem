package view;

import controller.SecurityService;
import model.Section;
import model.Sensor.SensorType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

class InstallationConfigurePanel extends JPanel {
    private static String[] COLUMN_NAMES = {"Section Id", "Section Name", "Motion", "Temperature"};

    InstallationConfigurePanel() {
        SecurityService securityService = SecurityService.getInstance();
        List<Section> sectionList = securityService.getBuildingSections();
        int rowCount = sectionList.size();
        int columnCount = COLUMN_NAMES.length;
        Object[][] data = new Object[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            Section section = sectionList.get(i);
            data[i][0] = section.getId();
            data[i][1] = section.getName();
            data[i][2] = section.isSensorInstalled(SensorType.MOTION);
            data[i][3] = section.isSensorInstalled(SensorType.TEMPERATURE);
        }

        CustomTableModel tableModel = new CustomTableModel(data, COLUMN_NAMES);

        JTable table = new JTable(tableModel);
        table.setBackground(Color.GRAY);
        add(new JScrollPane(table));

        JButton actionButton = new JButton("Edit");
        actionButton.addActionListener(e -> {
            if (tableModel.isCellEditable()) {
                actionButton.setText("Edit");
                tableModel.setCellEditable(false);

                for (int row = 0; row < rowCount; row++) {
                    Section section = sectionList.get(row);
                    section.setSensorInstalled(SensorType.MOTION, (Boolean) tableModel.getValueAt(row, 2));
                    section.setSensorInstalled(SensorType.TEMPERATURE, (Boolean) tableModel.getValueAt(row, 3));
                }
                securityService.saveSensorConfig();
            } else {
                actionButton.setText("Save");
                tableModel.setCellEditable(true);
            }
        });
        add(actionButton);
    }

    private static class CustomTableModel extends DefaultTableModel {
        private boolean editable = false;

        CustomTableModel(Object[][] data, Object[] columnNames) {
            super(data, columnNames);
        }

        void setCellEditable(boolean editable) {
            this.editable = editable;
            this.fireTableDataChanged();
        }

        boolean isCellEditable() {
            return editable;
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return editable;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return getValueAt(0, columnIndex).getClass();
        }
    }
}
