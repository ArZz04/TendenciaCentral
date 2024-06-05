import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("---------------------------------------------------------------");


        System.out.println("-------------------| DATOS SIN AGRUPADOS: |--------------------");
        System.out.println("Media: " + DiscreteMaths.calculateMediaUGDS());
        System.out.println("Mediana: " + DiscreteMaths.calculateMedianaUGDS());
        System.out.println("Moda: " + DiscreteMaths.calculateModaUGDS());

        System.out.println("---------------------------------------------------------------");

        System.out.println("----------------------| DATOS AGRUPADOS: |---------------------");
        System.out.println("Media: " + DiscreteMaths.calculateMediaGDS());
        System.out.println("Mediana: " + DiscreteMaths.calculateMedianaGDS());
        System.out.println("Moda: " + DiscreteMaths.calculateModaGDS());
    }
}