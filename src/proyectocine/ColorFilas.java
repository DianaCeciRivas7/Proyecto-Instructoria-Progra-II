package proyectocine;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColorFilas extends DefaultTableCellRenderer {
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component componenteTabla = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row % 2 == 0) {
            componenteTabla.setBackground(Color.LIGHT_GRAY);
        } else {
            componenteTabla.setBackground(Color.GRAY);
        }
        return componenteTabla;
    }

}
