import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.*; 
import javax.swing.*;
import javax.swing.border.Border;

import Series.Exponentials;
import Series.Linear;
import Series.Series; 

public class MyFrame1 extends JFrame {
	private String[] data = { "Linear", "Exponentials"};
	private JComboBox box=new JComboBox(data);
	private JPanel panel=new JPanel();
	private JPanel panel1=new JPanel(); 
	private JButton create=new JButton("Create");
	private Action action=new Action();
	private JTextField firstElement,coficentB;
    private static Series series;	
	public MyFrame1() {
		super("Linear");
		setLayout(new BorderLayout());
		create.addActionListener(action);
		firstElement=new JTextField("first element",10);
    	coficentB=new JTextField("coficentB",10);
        panel.add(coficentB);
        panel.add(firstElement);
		panel.add(box);
		panel.add(create);
		add(panel,BorderLayout.NORTH);
	}
	public class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
           if (e.getSource()==create) {
        	   try {
        	   int coficentB1=Integer.parseInt(coficentB.getText());
        	   int firstElement1=Integer.parseInt(firstElement.getText());
        	   switch(box.getSelectedIndex()){
        	   case 0:{
        		   series=new Linear(firstElement1,coficentB1);
        		   break;
        	   }
        	   case 1:{
        		   series=new Exponentials(firstElement1,coficentB1);
        		   break;
        	   }
        	   }
        	   //
        	   JButton findJElements,sumOfSeries,viewElements,save;
        	   JTextField J=new JTextField("J",8);
        	   findJElements=new JButton("find J Elements");
        	   sumOfSeries=new JButton("sum of series");
        	   viewElements=new JButton("view elements");
        	   save=new JButton("save");
        	   findJElements.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					int j=Integer.parseInt(J.getText());
					JOptionPane.showMessageDialog(new JFrame(), "j elements = "+series.getIndexElement(j),"INFO",JOptionPane.INFORMATION_MESSAGE);
				}
        		   
        	   });
        	   
        	   
        	   
        	   
        	   sumOfSeries.addActionListener(new ActionListener() {

   				@Override
   				public void actionPerformed(ActionEvent arg0) {
   					int j=Integer.parseInt(J.getText());
   					JOptionPane.showMessageDialog(new JFrame(), "sum of series = "+series.sumOfSeries(j),"INFO",JOptionPane.INFORMATION_MESSAGE);
   				}
           		   
           	   });
        	   viewElements.addActionListener(new ActionListener() {

   				@Override
   				public void actionPerformed(ActionEvent arg0) {
   					int j=Integer.parseInt(J.getText());
   					JOptionPane.showMessageDialog(new JFrame(),series.toString(j),"INFO",JOptionPane.INFORMATION_MESSAGE);
   				}
           		   
           	   });
        	   
        	   
        	   
        	   save.addActionListener(new ActionListener() {

      				@Override
      				public void actionPerformed(ActionEvent arg0) {
      					int j=Integer.parseInt(J.getText());
      					String info=series.toString(j);
      					File file=new File("INFO.txt");
      					
      					
      					try(FileWriter writer = new FileWriter(file))
      			        {
      			            writer.write(info);    
      			            writer.flush();
      			        }
      			        catch(IOException ex){
      			             
      			        	JOptionPane.showMessageDialog(new JFrame(),ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
      			        } 
      					
      					
      					
      					
      					
      					
      					
      					
      					
      					JOptionPane.showMessageDialog(new JFrame(),"Complited","INFO",JOptionPane.INFORMATION_MESSAGE);
      				}
              		   
              	   });
        	   
        	   
        	   
        	   
        	   
        	   
        	   
        	   //
        	   Border border=BorderFactory.createLineBorder(Color.BLACK);
        	   panel1.add(J);
        	   panel1.add(viewElements);
        	   panel1.add(sumOfSeries);
        	   panel1.add(findJElements);
        	   panel1.add(save);
        	   panel1.setBorder(border);
        	   panel1.add(findJElements);
        	   add(panel1);
        	   repaint();
        	   create.setEnabled(false);
        	   box.setEnabled(false);
        	   firstElement.setEnabled(false);
        	   coficentB.setEnabled(false);
        	   JOptionPane.showMessageDialog(new JFrame(), "COMPLITED","INFO",JOptionPane.INFORMATION_MESSAGE);
        	   }
        	   catch(Exception ee) {
        		   JOptionPane.showMessageDialog(new JFrame(), "first element and coficent b must be int!!!","Create Error",JOptionPane.ERROR_MESSAGE);
        	   }
        	   }
		}
		
	}
	public void paint(Graphics g) {
		super.paintComponents(g);
	}
}
