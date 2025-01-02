package software.ulpgc.kata_3.app.windows;

import software.ulpgc.kata_3.arquitecture.control.SelectStatisticCommand;
import software.ulpgc.kata_3.arquitecture.io.FileDinosaurLoader;
import software.ulpgc.kata_3.arquitecture.io.CsvDinosaurDeserializer;
import software.ulpgc.kata_3.arquitecture.io.StatisticBarchartLoader;
import software.ulpgc.kata_3.arquitecture.model.Dinosaur;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\User\\Universidad\\3º\\IS2\\katas\\kata2\\archive\\data.csv");
        List<Dinosaur> dinosaurs = new FileDinosaurLoader(file, new CsvDinosaurDeserializer()).load();
        Map<String, Integer> dietscount = new HashMap<>();
        Map<String, Integer> periodscount = new HashMap<>();
        for (Dinosaur dinosaur: dinosaurs) {
            //System.out.println(dinosaur);
            dietscount.put(dinosaur.getDiet(), dietscount.getOrDefault(dinosaur.getDiet(), 0)+1);
            periodscount.put(dinosaur.getPeriod(), periodscount.getOrDefault(dinosaur.getPeriod(), 0)+1);
        }
        MainFrame mainFrame = new MainFrame();
        StatisticBarchartLoader loader = new StatisticBarchartLoader(dietscount, periodscount);
        mainFrame.put("select", new SelectStatisticCommand(mainFrame.getSelectBarchartDialog(), loader, mainFrame.getBarchartDisplay()));
        mainFrame.getBarchartDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
    }
}
