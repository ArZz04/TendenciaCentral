import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------------------------------------------------------------");
        List<Double> ungroupedData = Arrays.asList(1.0, 2.0, 2.0, 3.0, 4.0);
        UnGroupeDS ungroupedDataSet = new UnGroupeDS(ungroupedData);

        System.out.println("-------------------| DATOS SIN AGRUPADOS: |--------------------");
        System.out.println("Media: " + DiscreteMaths.calculateMediaUGDS(ungroupedDataSet));
        System.out.println("Mediana: " + DiscreteMaths.calculateMedianaUGDS(ungroupedDataSet));
        System.out.println("Moda: " + DiscreteMaths.calculateModaUGDS(ungroupedDataSet));

        System.out.println("---------------------------------------------------------------");

        Map<Double, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(1.0, 1);
        frequencyMap.put(2.0, 2);
        frequencyMap.put(3.0, 1);
        frequencyMap.put(4.0, 1);
        GroupDS groupedDataSet = new GroupDS(new ArrayList<>(frequencyMap.keySet()), frequencyMap);

        System.out.println("----------------------| DATOS AGRUPADOS: |---------------------");
        System.out.println("Media: " + DiscreteMaths.calculateMediaGDS(groupedDataSet));
        System.out.println("Mediana: " + DiscreteMaths.calculateMedianaGDS(groupedDataSet));
        System.out.println("Moda: " + DiscreteMaths.calculateModaGDS(groupedDataSet));
    }
}