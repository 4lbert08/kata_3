package software.ulpgc.kata_3.arquitecture.io;

import software.ulpgc.kata_3.arquitecture.model.Dinosaur;

public class CsvDinosaurDeserializer implements DinosaurDeserializer {
    @Override
    public Dinosaur deserialize(String line) {
        return deserialize(line.split(","));
    }

    private Dinosaur deserialize(String[] fields) {
        return new Dinosaur(fields[0],fields[1],periodDeserializer(fields[2].split(" ")),fields[5]);
    }

    private String periodDeserializer(String[] fields) {
        if (fields.length < 2)return fields[0];
        return fields[0]+ " " + fields[1];
    }
}
