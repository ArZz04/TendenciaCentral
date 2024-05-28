import java.util.*;
import java.util.stream.Collectors;

public class DiscreteMaths {

    public static double calculateMeanUGDS(UnGroupeDS dataSet) {
        List<Double> data = dataSet.getData();
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.size();
    }

    public static double calculateMedianUGDS(UnGroupeDS dataSet) {
        List<Double> data = dataSet.getData();
        Collections.sort(data);
        int size = data.size();
        if (size % 2 == 0) {
            return (data.get(size / 2 - 1) + data.get(size / 2)) / 2.0;
        } else {
            return data.get(size / 2);
        }
    }

    public static double calculateModeUGDS(UnGroupeDS dataSet) {
        List<Double> data = dataSet.getData();
        Map<Double, Long> frequencyMap = data.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        long maxCount = Collections.max(frequencyMap.values());
        return frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .findFirst().orElse(Double.NaN);
    }

    public static double calculateMeanGDS(GroupDS dataSet) {
        Map<Double, Integer> frequencyMap = dataSet.getFrequencyMap();
        double sum = 0;
        int totalFrequency = 0;

        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            sum += entry.getKey() * entry.getValue();
            totalFrequency += entry.getValue();
        }

        return sum / totalFrequency;
    }

    public static double calculateMedianGDS(GroupDS dataSet) {
        Map<Double, Integer> frequencyMap = dataSet.getFrequencyMap();
        List<Double> data = dataSet.getData();
        int size = data.size();
        Collections.sort(data);

        int cumulativeFrequency = 0;
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            cumulativeFrequency += entry.getValue();
            if (cumulativeFrequency >= size / 2) {
                return entry.getKey();
            }
        }

        return Double.NaN;
    }

    public static double calculateModeGDS(GroupDS dataSet) {
        Map<Double, Integer> frequencyMap = dataSet.getFrequencyMap();
        int maxFrequency = Collections.max(frequencyMap.values());
        return frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .findFirst().orElse(Double.NaN);
    }

}
