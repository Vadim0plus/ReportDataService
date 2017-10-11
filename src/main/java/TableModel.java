import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TableModel {
    private List<String> columnNames;
    private List<Object[]> data;

    public TableModel() {
        data = new ArrayList<Object[]>();
        columnNames = new ArrayList<String>();
    }

    public TableModel(String[] columnNames, Object[][] data) {
        this(columnNames.length,data.length);
        for(Object[] obj : data)
            this.data.add(obj);
        this.columnNames.addAll(Arrays.asList(columnNames));
    }

    public TableModel(String[] columnNames, int rowCount) {
        this(columnNames.length, rowCount);
        this.columnNames.addAll(Arrays.asList(columnNames));
    }

    public TableModel(int rowCount, int columnCount) {
        data = new ArrayList<Object[]>(rowCount);
        columnNames = new ArrayList<String>(columnCount);
    }

    public void addColumn(String columnName) {
        insertColumn(columnName, this.getColumnCount() - 1);
    }

    public void addColumn(String columnName, Object[] columnData) {
        insertColumn(columnName, getColumnCount() - 1,columnData);
    }

    public void insertColumn(String columnName, int pos) {
        Object[] newData = new Object[getColumnCount() + 1];
        Arrays.fill(newData,null);
        insertColumn(columnName,pos,newData);
    }

    public void insertColumn(String columnName, int pos, Object[] columnData) {
        this.columnNames.add(pos,columnName);
        Iterator<Object[]> iter = this.data.iterator();
        for(int i = 0; i < this.data.size(); i++) {
            Object[] newArray = new Object[getColumnCount() + 1];
            System.arraycopy(this.data.get(i),0,newArray,0,pos+1);
            newArray[pos+1] = columnData[i];
            System.arraycopy(this.data.get(i),pos+1,newArray,pos+2,getColumnCount()-pos-1);
            this.data.set(i,newArray);
        }
    }


    public int getColumnCount() {
        return columnNames.size();
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    public Object getValueAt(int row,int column) {
        Object[] rowData = data.get(row);
        return rowData[column];
    }

    public void setValueAt(Object value, int row, int column) {
        Object[] rowData = data.get(row);
        rowData[column] = value;
    }

    public Object[] getRow(int row) {
        return data.get(row).clone();
    }

    public void addRow(Object[] data) {
        insertRow(getRowCount()-1,data);
    }

    public void insertRow(int row, Object data[]) {
        this.data.add(row,data);
    }

    public void removeRow(int row) {
        this.data.remove(row);
    }

    public void moveRow(int start, int end, int to) {
    }

    public void replaceRow(int pos, Object[] data) {
        this.data.set(pos,data);
    }

    public void setColumnClass() {
    }

    public Class<?> getColumnClass(int col) {
        Object row = this.data.get(0);
        return row.getClass();
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
