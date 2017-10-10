import java.util.List;

public interface DataDAO {
    List<Customer> getAllCustomers();

    List<Employee> getAllEmployees();

    List<Supplier> getAllSuppliers();
}
