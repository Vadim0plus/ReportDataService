import java.util.List;

public class EmployeesReport extends FormatAbstractReporter {

    DataDAO dataDAO;

    public EmployeesReport() {
        this.serviceType = "EmployeesReport";
    }


    public DataDAO getDataDAO() {
        return dataDAO;
    }

    public void setDataDAO(DataDAO dataDAO) {
        this.dataDAO = dataDAO;
    }

    protected TableModel tableFromList(List<Employee> list) {
        TableModel table = new TableModel();
        table.addColumn("Last Name");
        table.addColumn("First Name");
        table.addColumn("Birth Date");
        table.addColumn("Notes");

        list.stream().forEach( (employee) -> {
            String[] row = new String[4];
            row[0] = employee.getLastName();
            row[1] = employee.getFirstName();
            row[2] = employee.getBirthDate();
            row[3] = employee.getNotes().toString();
            table.addRow(row);
        });

        return table;
    }


    @Override
    protected void write(StringBuffer response) {
        List<Employee> employeeList = dataDAO.getAllEmployees();
        TableModel table = tableFromList(employeeList);
        response.append(fromTableToText(table));
    }
}
