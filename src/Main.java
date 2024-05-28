import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------------------------------------------------------------");
        List<Double> ungroupedData = Arrays.asList(1.0, 2.0, 2.0, 3.0, 4.0);
        UnGroupeDS ungroupedDataSet = new UnGroupeDS(ungroupedData);

        System.out.println("-------------------| DATOS SIN AGRUPADOS: |--------------------");
        System.out.println("Media: " + DiscreteMaths.calculateMeanUGDS(ungroupedDataSet));
        System.out.println("Mediana: " + DiscreteMaths.calculateMedianUGDS(ungroupedDataSet));
        System.out.println("Moda: " + DiscreteMaths.calculateModeUGDS(ungroupedDataSet));

        System.out.println("---------------------------------------------------------------");

        Map<Double, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(1.0, 1);
        frequencyMap.put(2.0, 2);
        frequencyMap.put(3.0, 1);
        frequencyMap.put(4.0, 1);
        GroupDS groupedDataSet = new GroupDS(new ArrayList<>(frequencyMap.keySet()), frequencyMap);

        System.out.println("----------------------| DATOS AGRUPADOS: |---------------------");
        System.out.println("Media: " + DiscreteMaths.calculateMeanGDS(groupedDataSet));
        System.out.println("Mediana: " + DiscreteMaths.calculateMedianGDS(groupedDataSet));
        System.out.println("Moda: " + DiscreteMaths.calculateModeGDS(groupedDataSet));
    }
}