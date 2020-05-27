import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class FieldPanel extends JPanel {

    private Universe universe;
    private int height;
    private int width;

    public FieldPanel(Universe universe) {
        this.universe = universe;



        setSize(604, 604);
        setBorder(BorderFactory.createEtchedBorder());
//        System.out.println("Field Panel: ");
//        System.out.println("width: " + getWidth() + ", height: " + getHeight() + " " + getInsets());
//        System.out.println();
        this.height = getHeight();
        this.width = getWidth();

    }


    @Override
    public void paintComponent(Graphics currentGraphics) {
        super.paintComponent(currentGraphics);

        Graphics2D graphics2D = (Graphics2D) currentGraphics;



//        System.out.println("getHeight() : " + height);
//        System.out.println("getWidth() : " + getWidth());
//        System.out.println("getInsets().top : " + getInsets().top);
//        System.out.println("getInsets().bottom : " + getInsets().bottom);
//        System.out.println("sizeOfTheUniverse : " + sizeOfTheUniverse);


        double horizontalDistanceBetweenLines = ((double) (width - (getInsets().left + getInsets().right))) / (double) universe.getSize();
        double verticalDistanceBetweenLines = ((double) (height - (getInsets().top + getInsets().bottom))) / (double) universe.getSize();
//        System.out.println("horizontal distance: " + horizontalDistanceBetweenLines);
//        System.out.println("vertical distance: " + verticalDistanceBetweenLines);
//        System.out.println();


        double startPointX = 2.0;
        double startPointY = 46.0 + verticalDistanceBetweenLines;

        double endPointX = 602.0;
        double endPointY = 46.0 + verticalDistanceBetweenLines;

//        System.out.println("Horizontal lines: ");
        for (int i = 1; i <= universe.getSize(); i++) {
            graphics2D.draw(new Line2D.Double(startPointX, startPointY, endPointX, endPointY));
//            System.out.println(i + ". line, " + "x: " + startPointX + ", y: " + startPointY);
//            currentGraphics.drawLine(startPointX, startPointY, endPointX, endPointY);
            startPointY += verticalDistanceBetweenLines;
            endPointY += verticalDistanceBetweenLines;
        }
//        System.out.println();

//
        startPointX = 2.0 + horizontalDistanceBetweenLines;
        startPointY = 46.0;
        endPointX = 2.0 + horizontalDistanceBetweenLines;
        endPointY = 646.0;
//
//        System.out.println("Vertical lines: ");
        for (int i = 1; i <= universe.getSize() + 1; i++) {
            graphics2D.draw(new Line2D.Double(startPointX, startPointY, endPointX, endPointY));
//            System.out.println(i + ". line, " + "x: " + startPointX + ", y: " + startPointY);
//            currentGraphics.drawLine(startPointX, startPointY, endPointX, endPointY);
            startPointX += horizontalDistanceBetweenLines;
            endPointX += horizontalDistanceBetweenLines;
        }

        double x = 2.0;
        double y = 46.0;
        for (int i = 0; i < universe.getSize(); i++) {
            for (int j = 0; j < universe.getSize(); j++) {
                if (universe.getCurrentStateOfTheUniverse()[i][j] == 'O') {
                    graphics2D.fill(new Rectangle.Double(x, y, horizontalDistanceBetweenLines, verticalDistanceBetweenLines));
                }
                x += horizontalDistanceBetweenLines;
            }
            x = 2.0;
            y += verticalDistanceBetweenLines;

        }

    }
}
