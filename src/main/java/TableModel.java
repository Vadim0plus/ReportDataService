import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TableModel {
    private List<String> columnNames;
    private List<String[]> data;

    public TableModel() {
        data = new ArrayList<String[]>();
        columnNames = new ArrayList<String>();
    }

    public TableModel(String[] columnNames, String[][] data) {
        this(columnNames.length,data.length);
        for(String[] obj : data)
            this.data.add(obj);
        this.columnNames.addAll(Arrays.asList(columnNames));
    }

    public TableModel(String[] columnNames, int rowCount) {
        this(columnNames.length, rowCount);
        this.columnNames.addAll(Arrays.asList(columnNames));
    }

    public TableModel(int rowCount, int columnCount) {
        data = new ArrayList<String[]>(rowCount);
        columnNames = new ArrayList<String>(columnCount);
    }

    public void addColumn(String columnName) {
        insertColumn(columnName, this.getColumnCount() - 1);
    }

    public void addColumn(String columnName, String[] columnData) {
        insertColumn(columnName, getColumnCount() - 1,columnData);
    }

    public void insertColumn(String columnName, int pos) {
        String[] newData = new String[getColumnCount() + 1];
        Arrays.fill(newData,null);
        insertColumn(columnName,pos,newData);
    }

    public void insertColumn(String columnName, int pos, String[] columnData) {
        this.columnNames.add(pos,columnName);
        Iterator<String[]> iter = this.data.iterator();
        for(int i = 0; i < this.data.size(); i++) {
            String[] newArray = new String[getColumnCount() + 1];
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

    public String[] getColumnNames() {
        return (String[])this.columnNames.toArray().clone();
    }

    public String getValueAt(int row,int column) {
        String[] rowData = data.get(row);
        return rowData[column];
    }

    public void setValueAt(String value, int row, int column) {
        String[] rowData = data.get(row);
        rowData[column] = value;
    }

    public String[] getRow(int row) {
        return data.get(row).clone();
    }

    public void addRow(String[] data) {
        insertRow(getRowCount()-1,data);
    }

    public void insertRow(int row, String data[]) {
        this.data.add(row,data);
    }

    public void removeRow(int row) {
        this.data.remove(row);
    }

    public void moveRow(int start, int end, int to) {
    }

    public void replaceRow(int pos, String[] data) {
        this.data.set(pos,data);
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
