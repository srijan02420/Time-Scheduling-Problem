import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List; 
 
import jp.co.wap.exam.lib.Interval; 
 
public class Problem1 { 
	
	private int counter;
	private int overlap;
	private int intervalsize;
	
 public int getMaxIntervalOverlapCount(List<Interval> intervals) { 
 // TODO: Implement this method. 
	 //Sort the intervals according to starting time
	 intervalsize = intervals.size();
	 if(intervalsize==0)
		 return 0; 
	 
	 else{
		 
		 List<int[]> all = new ArrayList<int[]>();
		 
		 for(int i=0;i<intervalsize;i++)
		 {
			 all.add(new int[]{intervals.get(i).getBeginMinuteUnit(),1});//for starting time
			 all.add(new int[]{intervals.get(i).getEndMinuteUnit(),2});//for ending time
		 }
		 
		 Collections.sort(all,new Sort());	//sorting all
		 
		 overlap = 0;
		 counter = 0;
		for(int i=0;i<all.size();i++)
		 {			 
			if(all.get(i)[1] == 1)
				 counter++;
			 else
				 counter--;
			overlap = Math.max(overlap,counter);
		 }
		 return overlap;
	 }
 } 
 //Class for comparing the time
 class Sort implements Comparator<int[]>{

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if(o1[0] < o2[0]){
	            return -1;
	        } else {
	            return 1;
	        }
		}
	}
 
} 