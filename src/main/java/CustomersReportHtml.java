import java.util.List;

public class CustomersReportHtml extends CustomersReport {

    public CustomersReportHtml() {
        this.serviceType = "CustomersReportHtml";
    }

    @Override
    protected void write(StringBuffer response) {

        List<Customer> customerList = dataDAO.getAllCustomers();
        TableModel table = tableFromList(customerList);
        response.append("Customers\n");
        response.append(fromTableToHtml(table));
    }
}
