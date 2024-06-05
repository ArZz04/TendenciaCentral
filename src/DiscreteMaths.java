import javax.xml.crypto.Data;
import java.util.*;
import java.util.stream.Collectors;

public class DiscreteMaths {

    static DataSet dataS = new DataSet();

    public static double calculateMediaUGDS() {
        double[] data = dataS.getUnGroupedData();
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.length;
    }

    public static double calculateMedianaUGDS() {
        double[] data = dataS.getUnGroupedData();
        Arrays.sort(data);
        int size = data.length;
        if (size % 2 == 0) {
            return (data[size / 2 - 1] + data[size / 2]) / 2.0;
        } else {
            return data[size / 2];
        }
    }

    public static double calculateModaUGDS() {
        double[] data = dataS.getUnGroupedData();
        Map<Double, Long> frequencyMap = Arrays.stream(data)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        long maxCount = Collections.max(frequencyMap.values());
        return frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .findFirst().orElse(Double.NaN);
    }

    public static double calculateMediaGDS() {
        DataSet dataS = new DataSet();
        double[][][] groupedData = dataS.getGroupedData();
        double sum = 0;
        int totalFrequency = 0;

        for (int i = 0; i < groupedData[0].length; i++) {
            double midpoint = (groupedData[0][i][0] + groupedData[0][i][1]) / 2.0;
            double frequency = groupedData[1][i][0]; // Acceso directo a la frecuencia del intervalo i

            sum += midpoint * frequency;
            totalFrequency += frequency;
        }

        return sum / totalFrequency;
    }

    public static double calculateMedianaGDS() {
        DataSet dataS = new DataSet();
        double[][][] groupedData = dataS.getGroupedData();
        double[][] frequencies = dataS.getFrequencies();
        double totalFrequency = Arrays.stream(frequencies).flatMapToDouble(Arrays::stream).sum();

        double midpoint = totalFrequency / 2.0;
        boolean isEven = totalFrequency % 2.0 == 0.0;

        double cumulativeFrequency = 0.0;
        for (int i = 0; i < groupedData[0].length; i++) {
            for (int j = 0; j < frequencies[i].length; j++) {
                cumulativeFrequency += frequencies[i][j];
                // Si la frecuencia acumulada supera o iguala el punto medio
                if (cumulativeFrequency >= midpoint || (isEven && cumulativeFrequency == midpoint)) {
                    // Calcular el límite inferior de la clase mediana
                    double li = groupedData[0][i][0];
                    // Calcular la frecuencia acumulada anterior a la clase mediana
                    double fa = cumulativeFrequency - frequencies[i][j];
                    // Calcular la frecuencia de la clase mediana
                    double fc = frequencies[i][j];
                    // Calcular el ancho de la clase
                    double classWidth = groupedData[0][i][1] - groupedData[0][i][0];
                    // Calcular la mediana utilizando la fórmula
                    return li + ((midpoint - fa) / fc) * classWidth;
                }
            }
        }

        return Double.NaN; // En caso de que no se encuentre la mediana
    }



    public static double calculateModaGDS() {
        DataSet dataS = new DataSet();
        double[][] frequencies = dataS.getFrequencies();

        // Encontrar la frecuencia máxima en todas las clases
        double maxFrequency = Arrays.stream(frequencies)
                .flatMapToDouble(Arrays::stream)
                .max()
                .orElse(0.0);

        // Obtener los puntos medios
        double[] midPoints = dataS.getMidPoints();

        // Iterar sobre las frecuencias para encontrar la moda
        for (int i = 0; i < frequencies.length; i++) {
            for (int j = 0; j < frequencies[i].length; j++) {
                if (frequencies[i][j] == maxFrequency) {
                    return midPoints[i];
                }
            }
        }

        return Double.NaN; // Devuelve NaN si no se encuentra ninguna moda
    }


}
