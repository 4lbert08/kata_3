package software.ulpgc.kata_3.arquitecture.io;

import software.ulpgc.kata_3.arquitecture.model.Barchart;

public interface BarchartLoader {
    Barchart load(int id);
}
