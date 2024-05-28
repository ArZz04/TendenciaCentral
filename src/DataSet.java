import java.util.List;

public abstract class DataSet {
    protected List<Double> data;

    public DataSet(List<Double> data) {
        this.data = data;
    }

    public List<Double> getData() {
        return data;
    }

    public abstract boolean isGrouped();
}