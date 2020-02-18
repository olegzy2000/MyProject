import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.awt.Robot;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;

class MyFrame extends JFrame{
    private final int w = 300;
    private final int h = 300;
    private ArrayList l = new ArrayList();
    private JPanel panel=new JPanel();
    private JButton openButton,saveButton,openPaintPanel;
    private boolean pictures=true;
    BufferedImage	img;
    MyPanel p;

    MyFrame(){
        super();
        setSize(w,h);
        setLayout(new BorderLayout());
        Border border=BorderFactory.createLineBorder(Color.BLACK);
        panel.setBorder(border);
        panel=new JPanel();
 	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
 	    openButton=new JButton("open");
 	    saveButton=new JButton("save");
 	    openButton.addActionListener(new ActionListener(){
 	    	public void actionPerformed(ActionEvent e) {
 	    	JFileChooser fileChooser = new JFileChooser();	
	    	fileChooser.setFileFilter(new FileFilter(){
 	    		public boolean accept(File f) {
 	    			if(f.getName().endsWith("JPG")) {
 	    				return true;
 	    			}
 	    			return false;
 	    		}

				@Override
				public String getDescription() {
					return "only gif files";
				}
 	    	});
 	    	fileChooser.showOpenDialog(new JPanel());
 	    	File file=fileChooser.getSelectedFile();
 	    	try {
				img = ImageIO.read(file);
 	    		
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 	    	pictures=false;
 	    	repaint();
 	    	
 	    }}
 	    );
 	   saveButton.addActionListener(new ActionListener(){

		
 		  public void actionPerformed(ActionEvent e) {
 	 	    	JFileChooser fileChooser = new JFileChooser();	
 		    	fileChooser.setFileFilter(new FileFilter(){
 	 	    		public boolean accept(File f) {
 	 	    			if(f.getName().endsWith("JPG")) {
 	 	    				return true;
 	 	    			}
 	 	    			return false;
 	 	    		}
 					public String getDescription() {
 						return "only gif files";
 					}
 	 	    	});
 		    	 String ra="*.JPG";
 		    	
					try {
						img = new Robot().createScreenCapture(p.getBounds());
					} catch (AWTException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					File file=new File("Pictures");
					try {
						ImageIO.write(img,"jpg",file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    pictures=false;
					
 	 	    }	   
 	   });
 	    
 	    
 	    
 	    openButton.setBounds(100,100, 50, 50);
 	    panel.add(openButton);
 	    panel.add(saveButton);
        setTitle("Test");
        p = new MyPanel(l, this);
        add(panel,BorderLayout.WEST);
        add(p);
    }

    public void addPoint(Point2D point2D){
        l.add(point2D);
    }


class MyPanel extends JPanel{
    private ArrayList l;
    MyPanel(ArrayList al, MyFrame f){
        super();
        Border border=BorderFactory.createLineBorder(Color.BLACK);
        setBorder(border);
        l = al;
        addMouseListener(new MyMouseClick(f));
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (pictures) {
        Graphics2D g2 = (Graphics2D)g;
        for (int i = 0; i < l.size(); ++i){
            int x = (int)((Point2D)(l.get(i))).getX();
            int y = (int)((Point2D)(l.get(i))).getY();
            g2.setColor(Color.BLUE);
            g.drawRect(x-1,y-1,5,5);
        }
        }
        else {
			g.clearRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
			g.drawImage(img, 0, 0, g.getClipBounds().width, g.getClipBounds().height, null);
			pictures=true;
        }
    }
}

class MyMouseClick extends MouseAdapter{
    private MyFrame f;
    MyMouseClick(MyFrame f){
        super();
        this.f = f;
    }

    public void mouseClicked(MouseEvent me){
        super.mouseClicked(me);
        f.addPoint (new Point2D.Float((float)me.getX(), (float)me.getY()));
        f.repaint();
    }
}
}