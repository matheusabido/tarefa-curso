package projeto;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Frame extends JFrame {
    
    public static final String DEFAULT_QUERY = "select * from authors";
    
    public final JTable table = new JTable();
    private ResultSetTableModel model;
    public Frame() throws Exception {
        super("Telinha");
        setLayout(new BorderLayout());
        
        // NORTH
        JTextArea textArea = new JTextArea(DEFAULT_QUERY, 3, 100);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        
        JScrollPane pane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JButton queryButton = new JButton("Query");
        queryButton.addActionListener(e -> query(textArea.getText()));
        
        Box boxNorth = Box.createHorizontalBox();
        boxNorth.add(pane);
        boxNorth.add(queryButton);
        
        // SOUTH
        Box boxSouth = Box.createHorizontalBox();
        JLabel label = new JLabel("Filter:");
        JTextField filterText = new JTextField();
        JButton applyFilterButton = new JButton("Apply");
        applyFilterButton.addActionListener(e -> filter(filterText.getText()));
        boxSouth.add(label);
        boxSouth.add(filterText);
        boxSouth.add(applyFilterButton);
        
        query(DEFAULT_QUERY);
        add(boxNorth, BorderLayout.NORTH);
        add(table, BorderLayout.CENTER);
        add(boxSouth, BorderLayout.SOUTH);
    }
    
    public void query(String query) {
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                this.model = new ResultSetTableModel(statement);
                table.setModel(model);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void filter(String filter) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        if (filter.length() == 0) sorter.setRowFilter(null);
        else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter(filter));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Incorrect RegEX", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private static Connection getConnection() throws Exception {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/programacao", "root", "admin");
    }
    
}