package software.ulpgc.arquitecture.control;

import software.ulpgc.arquitecture.io.BarchartLoader;
import software.ulpgc.arquitecture.view.BarchartDisplay;
import software.ulpgc.arquitecture.view.SelectBarchartDialog;

public class SelectStatisticCommand implements Command{
    private final SelectBarchartDialog dialog;
    private final BarchartLoader loader;
    private final BarchartDisplay display;

    public SelectStatisticCommand(SelectBarchartDialog dialog, BarchartLoader loader, BarchartDisplay display) {
        this.dialog = dialog;
        this.loader = loader;
        this.display = display;
    }

    @Override
    public void execute() {
        display.show(loader.load(dialog.getSelection()));
    }
}