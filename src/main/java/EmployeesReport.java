import java.util.List;

public class EmployeesReport extends AbstractReporter{

    DataDAO dataDAO;

    final private String begin_table = "" +
            "<table>\n" +
            "<tr>\n" +
            "<th>Last name</th>\n" +
            "<th>First name</th>\n" +
            "<th>Birth Date</th>\n" +
           // "<th>Photo</th>\n" +
            "<th>Notes</th>\n" +
            "</tr>\n";

    final private String end_table = "</table>\n";

    private String tag_td_wrapper(String str) {
        return "<td>"+str+"</td>\n";
    }

    public EmployeesReport() {
        this.serviceType = "EmployeesReport";
    }


    public DataDAO getDataDAO() {
        return dataDAO;
    }

    public void setDataDAO(DataDAO dataDAO) {
        this.dataDAO = dataDAO;
    }

    @Override
    protected void write(StringBuffer response) {

        List<Employee> employeeList = dataDAO.getAllEmployees();

        response.append("<h3>Employees</h3>\n");
        response.append(begin_table);

        employeeList.stream().forEach( (employee) -> {
            response.append("<tr>\n");
            response.append(tag_td_wrapper(employee.getLastName()));
            response.append(tag_td_wrapper(employee.getFirstName()));
            response.append(tag_td_wrapper(employee.getBirthDate()));
           // response.append(tag_td_wrapper(employee.getPhotoID())); // Don't implement
            response.append(tag_td_wrapper(employee.getNotes().toString()));
            response.append("</tr>\n");
        });

        response.append(end_table);
    }
}
