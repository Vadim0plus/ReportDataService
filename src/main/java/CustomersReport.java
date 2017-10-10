import java.util.List;
import java.util.stream.Stream;

public class CustomersReport extends AbstractReporter {

    DataDAO dataDAO;

    final String begin_table = "" +
            "<table>\n" +
            "<tr>\n" +
            "<th>Customer Name</th>\n" +
            "<th>Contact name</th>\n" +
            "<th>Address</th>\n" +
            "<th>City</th>\n" +
            "<th>Postal Code</th>\n" +
            "<th>Country</th>\n" +
            "</tr>\n";

    final String end_table = "</table>";

    private String tag_td_wrapper(String str) {
        return "<td>"+str+"</td>\n";
    }

    public CustomersReport() {
        this.serviceType = "CustomersReport";
    }


    public DataDAO getDataDAO() {
        return dataDAO;
    }

    public void setDataDAO(DataDAO dataDAO) {
        this.dataDAO = dataDAO;
    }

    @Override
    protected void write(StringBuffer response) {

        List<Customer> customerList = dataDAO.getAllCustomers();

        response.append("<h3>Customers</h3>\n");
        response.append(begin_table);

        customerList.stream().forEach( (customer) -> {
            response.append("<tr>\n");
            response.append(tag_td_wrapper(customer.getCustomerName()));
            response.append(tag_td_wrapper(customer.getContactName()));
            response.append(tag_td_wrapper(customer.getAddress()));
            response.append(tag_td_wrapper(customer.getCity()));
            response.append(tag_td_wrapper(customer.getPostalCode()));
            response.append(tag_td_wrapper(customer.getCountry()));
            response.append("</tr>\n");
        });

        response.append(end_table);
    }
}
