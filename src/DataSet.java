public class DataSet {
    private double[] ungroupedData;

    private double[][][] groupedData;

    public DataSet() {
        ungroupedData = new double[]  {72, 88, 65, 90, 78, 82, 75, 95, 87, 70, 70};

        groupedData = new double[][][]{
                {{60,63}, {63, 66}, {66,69}, {69,72}, {72, 75}},
                {{5.0}, {18.0}, {42.0}, {27.0}, {8.0}}
        };

        //groupedData = new double[][][]{
        //        {{1,20}, {21, 40}, {41,60}, {61, 80}, {81, 100}},
        //        {{5.0}, {15.0}, {80.0}, {400.0}, {83.0}}
        //};
    }

    public double[] getUnGroupedData() {
        return this.ungroupedData;
    }

    public double[][][] getGroupedData() {
        return this.groupedData;
    }

    public double[] getMidPoints() {
        double[] midPoints = new double[groupedData[0].length];
        for (int i = 0; i < groupedData[0].length; i++) {
            // Calcula el punto medio del rango actual
            midPoints[i] = (groupedData[0][i][0] + groupedData[0][i][1]) / 2.0;
        }
        return midPoints;
    }

    public double[][] getFrequencies() {
        return groupedData[1];
    }


}