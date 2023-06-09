package util;

import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 *
 * @author Laisa
 */
public class DeadLineColumnCellRenderer extends DefaultTableCellRenderer{
    
    
   @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col) {
        
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, 
                isSelected, hasFocus, row, col);
        label.setHorizontalAlignment(CENTER);
        
        TaskTableModel taskModel = (TaskTableModel) table.getModel();
        Task task = taskModel.getTasks().get(row);
        
        if(task.getDeadLine().after(new Date())){
            label.setBackground(GREEN);
        } else{
             label.setBackground(RED);
            
        }
        
        
        return label;
    }
}
