import java.util.Set;

public abstract class AbstractReporter {
    // next element in chain of responsibility
    protected AbstractReporter nextReporter;

    // type of reporter;
    String serviceType;

    public void setNextReporter(AbstractReporter nextReporter) {
        this.nextReporter = nextReporter;
    }

    public void writeReport(Set<String> params, StringBuffer response) {

        if(params.contains(serviceType)) {
            write(response);
        }
        else if(nextReporter != null) {
            nextReporter.writeReport(params, response);
        }
    }

    abstract protected void write(StringBuffer response);
}
