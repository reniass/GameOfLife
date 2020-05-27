import javax.swing.*;

public class CounterPanel extends JPanel {

    private JButton button1;
    private JButton button2;

    private JLabel generation;
    private JLabel alive;

    private Universe universe;

    public CounterPanel(Universe universe) {
        this.universe = universe;


        setSize(604, 44);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEtchedBorder());

        generation = new JLabel("Generation: #" +
                "" +
                "" + universe.getGeneration());
        alive = new JLabel("Alive: " + universe.getAliveCells());


        add(generation);
        add(alive);

    }

    public void setGeneration(int generationNumber) {
        generation.setText("Generation: #" + generationNumber);
    }

    public void setAlive(int aliveCellsNumber) {
        alive.setText("Alive: " + aliveCellsNumber);
    }


}
