import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ChainPatternReport {

    private AbstractReporter chainOfReporters;

    private static AbstractReporter getDefaultChainOfReporters() {
        AbstractReporter customersReport = new CustomersReport();
        AbstractReporter employeersReport = new EmployeesReport();
        AbstractReporter suppliersReport = new SuppliersReport();

        customersReport.setNextReporter(employeersReport);
        employeersReport.setNextReporter(suppliersReport);

        return customersReport;
    }

    public void setChainOfReporters(AbstractReporter chainOfReporters) {
        this.chainOfReporters = chainOfReporters;
    }

    public AbstractReporter getChainOfReporters() {
        return chainOfReporters;
    }

    public static void main(String[] args) {
        AbstractReporter reporter = getDefaultChainOfReporters();

        StringBuffer response = new StringBuffer();
        reporter.writeReport(new TreeSet<String>(Arrays.asList(args)),response );

        System.out.print(response);
    }
}
