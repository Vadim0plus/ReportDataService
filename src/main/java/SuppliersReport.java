import java.util.List;

public class SuppliersReport extends AbstractReporter {

    DataDAO dataDAO;

    final private String begin_table = "" +
            "<table>\n" +
            "<tr>\n" +
            "<th>Supplier Name</th>\n" +
            "<th>Contact Name</th>\n" +
            "<th>Address</th>\n" +
            "<th>City</th>\n" +
            "<th>Postal Code</th>\n" +
            "<th>Country</th>\n" +
            "<th>Phone</th>\n" +
            "</tr>\n";

    final private String end_table = "</table>";

    private String tag_td_wrapper(String str) {
        return "<td>"+str+"</td>\n";
    }

    public SuppliersReport() {
        this.serviceType = "SuppliersReport";
    }


    public DataDAO getDataDAO() {
        return dataDAO;
    }

    public void setDataDAO(DataDAO dataDAO) {
        this.dataDAO = dataDAO;
    }

    @Override
    protected void write(StringBuffer response) {

        List<Supplier> supplierList = dataDAO.getAllSuppliers();

        response.append("<h3>Suppliers</h3>\n");
        response.append(begin_table);

        supplierList.stream().forEach( (supplier) -> {
            response.append("<tr>\n");
            response.append(tag_td_wrapper(supplier.getSupplierName()));
            response.append(tag_td_wrapper(supplier.getContactName()));
            response.append(tag_td_wrapper(supplier.getAddress()));
            response.append(tag_td_wrapper(supplier.getCity()));
            response.append(tag_td_wrapper(supplier.getPostalCode()));
            response.append(tag_td_wrapper(supplier.getCountry()));
            response.append(tag_td_wrapper(supplier.getPhone()));
            response.append("</tr>\n");
        });

        response.append(end_table);
    }
}
