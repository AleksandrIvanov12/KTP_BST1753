import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FractalExplorer 
{
	// Display size 
	private int displaySize;
    // Image area for fractal
    private JImageDisplay image;
    // Used to generate fractals of a specified kind
    private FractalGenerator gen;
    // The current viewing area that we displaying
    private Rectangle2D.Double range;

    // Constructor 

    public FractalExplorer(int displaySize) 
    {
        this.displaySize = displaySize;
        this.gen = new Mandelbrot();
        this.range = new Rectangle2D.Double(0, 0, 0, 0);
        gen.getInitialRange(this.range);   
    }


     
    // Sets up GUI

    public void createAndShowGUI() 
    {
        // Creates the GUI
        JFrame frame = new JFrame("Fractal Explorer");
        image = new JImageDisplay(displaySize, displaySize);
        JButton resetButton = new JButton("Reset");
        
        // Adds listeners
        ActionHandler aHandler = new ActionHandler();
        MouseHandler mHandler = new MouseHandler();
        resetButton.addActionListener(aHandler);
        image.addMouseListener(mHandler);
        
        // Puts all of the components into the Frame
        frame.setLayout(new java.awt.BorderLayout());
        frame.add(image, java.awt.BorderLayout.CENTER);
        frame.add(resetButton, java.awt.BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Displays the image
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    // Fractal generator
    private void drawFractal() 
    {

    	//Drawing fractal pixel by pixel

    	for (int i = 0; i < displaySize; i++) 
    	{
            for (int j = 0; j < displaySize; j++) 
            {
                double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, i);
                double yCoord = FractalGenerator.getCoord(range.y, range.y + range.width, displaySize, j);
                double numIters = gen.numIterations(xCoord, yCoord);
                
                if (numIters == -1) 
                {
                    // Color pixel black if its not set
                    image.drawPixel(i, j, 0);
                }
                else 
                {

                    //Color of pixel based on the number of iterations

                    float hue = 0.7f + (float) numIters / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    image.drawPixel(i, j, rgbColor);
                }
            }
        }
        // Refreshing JimageDisplay
        image.repaint();
    }

    // Handler to reset the zoom level
    public class ActionHandler implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            gen.getInitialRange(range);
            drawFractal();
        }
    }

    // Handler to zoom in on the clicked pixel
    public class MouseHandler extends MouseAdapter 
    {
        @Override
        public void mouseClicked(MouseEvent e) 
        {
            double xCoord = FractalGenerator.getCoord(range.x, range.x + range.width, displaySize, e.getX());
            double yCoord = FractalGenerator.getCoord(range.y, range.y + range.width, displaySize, e.getY());
            gen.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
    }

    // Main method to run application
    public static void main(String[] args) 
    {
        FractalExplorer fracExp = new FractalExplorer(600);
        fracExp.createAndShowGUI();
        fracExp.drawFractal();
    }
}