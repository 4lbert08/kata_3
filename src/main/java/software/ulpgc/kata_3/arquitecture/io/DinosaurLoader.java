package software.ulpgc.kata_3.arquitecture.io;

import software.ulpgc.kata_3.arquitecture.model.Dinosaur;

import java.io.IOException;
import java.util.List;

public interface DinosaurLoader {
    List<Dinosaur> load() throws IOException;
}
