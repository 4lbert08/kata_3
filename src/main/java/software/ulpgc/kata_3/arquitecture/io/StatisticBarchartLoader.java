package software.ulpgc.kata_3.arquitecture.io;

import software.ulpgc.kata_3.arquitecture.model.Barchart;

import java.util.Map;

public class StatisticBarchartLoader implements BarchartLoader{
    private final Map<String, Integer> dietsCount;
    private final Map<String, Integer> periodsCount;

    public StatisticBarchartLoader(Map<String, Integer> dietsCount, Map<String, Integer> periodsCount) {
        this.dietsCount = dietsCount;
        this.periodsCount = periodsCount;
    }

    @Override
    public Barchart load(int id) {
        return switch (id) {
            case 0 -> barchartLoaderOf(dietsCount, "Dinosaurs Diets", "Diets", "Count");
            case 1 -> barchartLoaderOf(periodsCount, "Dinosaurs Periods", "Periods", "Count");
            default -> null;
        };
    }

    private Barchart barchartLoaderOf(Map<String, Integer> map, String title, String xAxis, String yAxis) {
        return new Barchart(map,title,xAxis,yAxis);
    }
}
