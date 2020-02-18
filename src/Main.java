import javax.swing.JFrame;

import Series.Exponentials;
import Series.Linear;
import Series.Series;

public class Main {
    public static void main(String[] args) {
    	try {
			//Series object=new Exponentials(4,5);
			//System.out.println(object.toString(10));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
    	
    	
        MyFrame myFrame = new MyFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	    myFrame.setSize(600, 400);//задаем размер окна
  	    myFrame.setVisible(true);//форма будет видимой*/
    	
    	MyFrame1 myFrame1=new MyFrame1();
    	myFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	    myFrame1.setSize(600, 400);//задаем размер окна
  	    myFrame1.setVisible(true);//форма будет видимой*/
    	
    }
}
