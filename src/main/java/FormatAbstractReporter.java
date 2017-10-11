import java.util.List;

abstract public class FormatAbstractReporter extends AbstractReporter {

    final private String BEGIN_TABLE = "<table>\n";
    final private String END_TABLE = "</table>\n";


    protected StringBuffer fromTableToHtml(TableModel table) {
        StringBuffer buf = new StringBuffer();

        buf.append(BEGIN_TABLE);

        String[] columnNames = table.getColumnNames();

        buf.append("<tr>\n");
        for(String col : columnNames) {
            buf.append("<th>"+col+"</th>\n");
        }
        buf.append("</tr>\n");

        for(int i = 0; i < table.getRowCount(); i++) {
            buf.append("<tr>\n");
            for (int j = 0; j < table.getColumnCount(); j++)
                buf.append("<td>" + table.getValueAt(i, j) + "</td>\n");
            buf.append("</tr>\n");
        }

        buf.append(END_TABLE);

        return buf;
    }

    protected StringBuffer fromTableToText(TableModel table) {
        StringBuffer buf = new StringBuffer();

        String[] columnNames = table.getColumnNames();

        for(String col : columnNames) {
            buf.append(col+"\t");
        }
        buf.append("\n");

        for(int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++)
                buf.append(table.getValueAt(i, j)+ "\t");
            buf.append("\n");
        }
        return buf;
    }
}
