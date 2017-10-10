import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeesReportTest {

    private List<Employee> employeesList;

    private StringBuffer waitResponse = new StringBuffer(
            "<h3>Employees</h3>\n" +
            "<table>\n" +
            "<tr>\n" +
            "<th>Last name</th>\n" +
            "<th>First name</th>\n" +
            "<th>Birth Date</th>\n" +
            "<th>Notes</th>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td>Giren</td>\n" +
            "<td>Alan</td>\n" +
            "<td>31-01-1996</td>\n" +
            "<td>Notes about Alan</td>\n" +
            "</tr>\n" +
            "</table>\n");

    @Before
    public void initEmployeeList() {
        employeesList = new ArrayList<Employee>();

        Employee employee = new Employee();
        employee.setFirstName("Alan");
        employee.setLastName("Giren");
        employee.setBirthDate("31-01-1996");
        employee.setNotes(new StringBuffer("Notes about Alan"));
        employeesList.add(employee);
    }

    @Test
    public void writeTest() {

        EmployeesReport reporter = new EmployeesReport();
        DataDAO dataDAO = mock(DataDAO.class);

        reporter.setDataDAO(dataDAO);
        when(dataDAO.getAllEmployees()).thenReturn(employeesList);

        StringBuffer response = new StringBuffer();
        Set<String> params = new TreeSet<String>();
        params.add("EmployeesReport");

        reporter.writeReport(params, response);
        assertEquals(waitResponse.toString(), response.toString());

    }
}
