package software.ulpgc.kata_3.app.windows;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import software.ulpgc.kata_3.arquitecture.model.Barchart;
import software.ulpgc.kata_3.arquitecture.view.BarchartDisplay;

import javax.swing.*;
import java.awt.*;

public class JfreeBarchartDisplay extends JPanel implements BarchartDisplay {

    public JfreeBarchartDisplay() {
        setLayout(new BorderLayout());
    }

    @Override
    public void show(Barchart barchart) {
        removeAll();
        add(new ChartPanel(adapt(barchart)));
        revalidate();
    }

    private JFreeChart adapt(Barchart barchart) {
        return JfreeBarchartAdapter.adapt(barchart);
    }
}
