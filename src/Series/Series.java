package Series;

public abstract class Series implements Comparable , Iterator {
   public abstract float sumOfSeries(int index);
   public abstract float getFirstElement();
   public abstract float getCoficentB();
   public abstract String toString(int index);
}
