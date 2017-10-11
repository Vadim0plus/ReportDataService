import java.util.List;

public class EmployeesReportHtml extends EmployeesReport {

    public EmployeesReportHtml() {
        this.serviceType = "EmployeesReportHtml";
    }

    @Override
    protected void write(StringBuffer response) {
        List<Employee> employeeList = dataDAO.getAllEmployees();
        TableModel table = tableFromList(employeeList);
        response.append(fromTableToHtml(table));
    }
}
