import javax.swing.*;
import java.util.List;

public class GameOfLife extends JFrame {

    private CounterPanel counterPanel;
    private FieldPanel fieldPanel;

    private Universe universe;


    public GameOfLife(Universe universe) {
        super("Game of life");
        this.universe = universe;
//        universe.createTheUniverse();

//        setLayout(new BorderLayout());

        counterPanel = new CounterPanel(universe);
        counterPanel.setName("GenerationLabel");
        fieldPanel = new FieldPanel(universe);
        fieldPanel.setName("AliveLabel");

        add(counterPanel);
        add(fieldPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(620, 687);
        setVisible(true);

    }

    public void startTheGame() throws InterruptedException {
        SwingWorker<Void, Universe> worker = new SwingWorker<Void, Universe>() {
            @Override
            protected Void doInBackground() throws Exception {
                universe.createTheUniverse();
//                for (int i = 0; i < 50; i++) {
//                    Thread.sleep(1000);
//                    universe.createNextGenerationOfTheUniverse();
//                    publish(universe);
//
//                }
                while (true) {
                    Thread.sleep(1000);
                    universe.createNextGenerationOfTheUniverse();
                    publish(universe);
                }
            }

            @Override
            protected void process(List<Universe> chunks) {
                for (Universe universe: chunks) {
                    counterPanel.setGeneration(universe.getGeneration());
                    counterPanel.setAlive(universe.getAliveCells());
                    fieldPanel.repaint(2, 46, 600, 600);
                }
        }

            @Override
            protected void done() {
                super.done();
            }
        };

        worker.execute();


    }
}
