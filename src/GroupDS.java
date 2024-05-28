import java.util.List;
import java.util.Map;

public class GroupDS extends DataSet {
    private final Map<Double, Integer> frequencyMap;

    public GroupDS(List<Double> data, Map<Double, Integer> frequencyMap) {
        super(data);
        this.frequencyMap = frequencyMap;
    }

    public Map<Double, Integer> getFrequencyMap() {
        return frequencyMap;
    }

    @Override
    public boolean isGrouped() {
        return true;
    }
}