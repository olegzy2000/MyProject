package Series;

public class Linear extends Series {
  private float firstElement;
  private float coficentB;
  static int size=0;
  
  public Linear(String value) throws Exception {
	  for (int i=0;i<value.length();i++) {
		  String number="";
		  while(value.charAt(i)!=' ' ) {
		  if (value.charAt(i)<47 && value.charAt(i)>48 && value.charAt(i)!=' ' && value.charAt(i)!='\n') {
			  throw new Exception("ERROR in input string\n");
		  }
		  else if (value.charAt(i) !=' ') {
			  number+=value.charAt(i);
		  }
		  i++;
		  }
		  this.firstElement=Integer.parseInt(number);
		  number="";
		  i++;
		  while(value.length()>i) {
			  if (value.charAt(i)<47 && value.charAt(i)>48 && value.charAt(i)!=' ' && value.charAt(i)!='\n') {
				  throw new Exception("ERROR in input string\n");
			  }
			  else if (value.charAt(i) !=' ') {
				  number+=value.charAt(i);
			  }
			  i++;
		   }
		  this.coficentB=Integer.parseInt(number);
		  this.size=1;
	  }
	  
  }
  public Linear(float firstElement,float coficentB) {
	  this.coficentB=coficentB;
	  this.firstElement=firstElement;
	  this.size=size;
  }
  
  
  
  public float getIndexElement(int index) {
	  return this.firstElement+(index-1)*this.coficentB;
  }
  
  
  public float sumOfSeries(int index) {
	  float sum=0;
	  for (int i=0;i<index;i++) {
		  sum+=(this.firstElement+i*this.coficentB);
	  }
	  return sum;
  }
  public boolean equals(Linear obj) {
	  return this.coficentB==obj.coficentB;
  }
  
  
  
  public String toString(int index) {
	  String result="Elemets of series:\n";
	  for (int i=0;i<index;i++) {
		  result+=(this.firstElement+i*this.coficentB)+" ";
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
  
  
}
