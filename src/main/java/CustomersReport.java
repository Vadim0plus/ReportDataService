import java.util.List;
import java.util.stream.Stream;

public class CustomersReport extends FormatAbstractReporter {

    DataDAO dataDAO;

    public CustomersReport() {
        this.serviceType = "CustomersReport";
    }


    public DataDAO getDataDAO() {
        return dataDAO;
    }

    public void setDataDAO(DataDAO dataDAO) {
        this.dataDAO = dataDAO;
    }

    protected TableModel tableFromList(List<Customer> list) {
        TableModel table = new TableModel();
        table.addColumn("Customer Name");
        table.addColumn("Contact Name");
        table.addColumn("Address");
        table.addColumn("City");
        table.addColumn("Postal Code");
        table.addColumn("Country");

        list.stream().forEach( (customer) -> {
            String[] row = new String[6];
            row[0] = customer.getCustomerName();
            row[1] = customer.getContactName();
            row[2] = customer.getAddress();
            row[3] = customer.getCity();
            row[4] = customer.getPostalCode();
            row[5] = customer.getCountry();
            table.addRow(row);
        });

        return table;
    }

    @Override
    protected void write(StringBuffer response) {
        List<Customer> customerList = dataDAO.getAllCustomers();
        response.append("<h3>Customers</h3>\n");
        response.append(fromTableToHtml(tableFromList(customerList)));
    }
}
