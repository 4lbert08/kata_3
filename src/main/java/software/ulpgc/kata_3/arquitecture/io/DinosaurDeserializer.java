package software.ulpgc.kata_3.arquitecture.io;

import software.ulpgc.kata_3.arquitecture.model.Dinosaur;

public interface DinosaurDeserializer {
    Dinosaur deserialize(String line);
}
