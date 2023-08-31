package projeto;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
import java.util.ArrayList;

public class ResultSetTableModel extends AbstractTableModel {

    private final ArrayList<Object[]> results = new ArrayList<>();
    public final int rows, columns;
    public ResultSetTableModel(PreparedStatement statement) throws SQLException {
        ResultSetMetaData data = statement.getMetaData();
        this.columns = data.getColumnCount();
        try (ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i-1] = rs.getObject(i);
                }
                results.add(row);
            }
        }
        this.rows = results.size();
    }
    
    @Override
    public int getRowCount() {
        return rows;
    }

    @Override
    public int getColumnCount() {
        return columns;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return results.get(rowIndex)[columnIndex];
    }
    
}