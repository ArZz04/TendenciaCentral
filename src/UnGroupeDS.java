import java.util.List;

public class UnGroupeDS extends DataSet {
    public UnGroupeDS(List<Double> data) {
        super(data);
    }

    @Override
    public boolean isGrouped() {
        return false;
    }
}