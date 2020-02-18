package Series;

public class Exponentials extends Series {
	private float firstElement;
	  private float coficentB;
	  static int size=0;
	  
	  
	  public Exponentials(float firstElement,float coficentB) {
		  this.coficentB=coficentB;
		  this.firstElement=firstElement;
		  this.size=size;
	  }
	  
	  
	  
	  public float getIndexElement(int index) {
		  return (float) (this.firstElement*Math.pow(this.coficentB,index-1));
	  }
	  
	  
	  public float sumOfSeries(int index) {
		  float sum=0;
		  for (int i=0;i<index;i++) {
			  sum+=getIndexElement(i+2);
		  }
		  return sum;
	  }
	  
	  
	  
	  
	  public String toString(int index) {
		  String result="Elemets of series:\n";
		  for (int i=0;i<index;i++) {
			  result+=(getIndexElement(i+2))+" ";
			  this.size++;
		  }
		  result+='\n';
		  result+="First element:";
		  result+=this.firstElement;
		  result+='\n';
		  result+="Coficent B:";
		  result+=this.coficentB;
		  result+='\n';
		  result+="sum of series:"+sumOfSeries(index)+'\n';
		  return result;
	  }
	  
	  
	  public float getFirstElement() {
		  return this.firstElement;
	  }
	  public  float getCoficentB() {
		  return this.coficentB;
	  }



	@Override
	public boolean equals(Linear obj) {
		// TODO Auto-generated method stub
		return false;
	}

	  
	  
	  
}
