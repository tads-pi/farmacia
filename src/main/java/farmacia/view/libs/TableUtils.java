package farmacia.view.libs;

import javax.swing.JTable;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.Timestamp;

public class TableUtils {
    /**
     * Adiciona função de tooltip automaticamente para a tabela informada
     * 
     * @param table
     */
    public static void addToolTip(JTable table) {
        table.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // do nothing
            }

            @Override
            public void mouseMoved(MouseEvent e) {

                // Set the tooltip to an empty string
                table.setToolTipText("");

                try {
                    // Get the table cell value where the mouse is located
                    String value = (String) table.getValueAt(table.rowAtPoint(e.getPoint()),
                            table.columnAtPoint(e.getPoint()));
                    // If the length of the value is greater than some number...
                    table.setToolTipText(value);
                } catch (java.lang.ClassCastException parseError) {
                    switch (parseError.getLocalizedMessage()) {
                        case "class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')":
                            // Get the table cell value where the mouse is located
                            int intValue = (Integer) table.getValueAt(
                                    table.rowAtPoint(e.getPoint()),
                                    table.columnAtPoint(e.getPoint()));
                            // If the length of the value is greater than some number...
                            table.setToolTipText(intValue + "");
                            break;
                        case "class java.lang.Double cannot be cast to class java.lang.String (java.lang.Double and java.lang.String are in module java.base of loader 'bootstrap')":
                            // Get the table cell value where the mouse is located
                            Double doubleValue = (Double) table.getValueAt(
                                    table.rowAtPoint(e.getPoint()),
                                    table.columnAtPoint(e.getPoint()));
                            // If the length of the value is greater than some number...
                            table.setToolTipText(doubleValue + "");
                            break;
                        case "class java.sql.Timestamp cannot be cast to class java.lang.String (java.sql.Timestamp is in module java.sql of loader 'platform'; java.lang.String is in module java.base of loader 'bootstrap')":
                            // Get the table cell value where the mouse is located
                            Timestamp TimestampValue = (Timestamp) table.getValueAt(
                                    table.rowAtPoint(e.getPoint()),
                                    table.columnAtPoint(e.getPoint()));
                            // If the length of the value is greater than some number...
                            table.setToolTipText(TimestampValue + "");
                            break;
                        default:
                            System.out.println("new parse error: " + parseError.getLocalizedMessage());
                    }
                } catch (Exception error) {
                    System.out.println("error: " + error);
                }
            }
        });
    }
}
