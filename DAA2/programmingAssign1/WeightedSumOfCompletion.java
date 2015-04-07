package programmingAssign1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WeightedSumOfCompletion {
	
	public Double setDiff(Double value1, Double value2){
		return (value1 - value2);
	}
	
	public Double setRation(Double value1, Double value2){
		return (value1 / value2);
	}	
	
	public static Comparator<Jobs>  diffComp = new Comparator<Jobs>(){

		@Override
		public int compare(Jobs o1, Jobs o2) {
			Double diff1 = o1.getComparator();
			Double diff2 = o2.getComparator();
			int result =  diff2.compareTo(diff1);
			if(result == 0){
				return o2.getWeight().compareTo(o1.getWeight());
			}
			return result;
		}		
	};
	
	public static Comparator<Jobs>  ratioComp = new Comparator<Jobs>(){

		@Override
		public int compare(Jobs o1, Jobs o2) {
			Double diff1 = o1.getComparator();
			Double diff2 = o2.getComparator();
			int result = diff2.compareTo(diff1);
			return result;
		}		
	};
	
	public List<Jobs> computeJobDiff(String filepath) throws IOException{
		List<Jobs> jobs1 = new ArrayList<Jobs>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String line;			
			String firstLine = br.readLine();
			int noofjobs = Integer.parseInt(firstLine);
			while((line = br.readLine()) != null){
				String[] values = line.split("\\s+", 0);
				Double value1 = Double.valueOf(values[0]);
				Double value2 = Double.valueOf(values[1]);
				jobs1.add(new Jobs(value1,value2,setDiff(value1, value2)));
			}
			System.out.println("No of Jobs processed:" +noofjobs);
			br.close();			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jobs1;
	}
	
	public List<Jobs> computeJobRatio(String filepath) throws IOException{
		List<Jobs> jobs1 = new ArrayList<Jobs>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String line;			
			String firstLine = br.readLine();
			int noofjobs = Integer.parseInt(firstLine);
			while((line = br.readLine()) != null){
				String[] values = line.split("\\s+", 0);
				Double value1 = Double.parseDouble(values[0]);
				Double value2 = Double.parseDouble(values[1]);
				jobs1.add(new Jobs(value1,value2,setRation(value1, value2)));
			}
			System.out.println("No of Jobs processed:" +noofjobs);
			br.close();			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return jobs1;
	}
	
	public static List<Jobs> sortList1(List<Jobs> list){
		Collections.sort(list, WeightedSumOfCompletion.diffComp);
		return list;		
	}
	public static List<Jobs> sortList2(List<Jobs> list){
		Collections.sort(list, WeightedSumOfCompletion.ratioComp);
		return list;		
	}
	
	public long weightedCompletionTime(List<Jobs> list){
		long cumulativeCompletionT = 0;
		double computeCompletionT = 0;
		for(Jobs job : list){
			computeCompletionT += job.getLength();			
			cumulativeCompletionT += (computeCompletionT * job.getWeight()); 
		}				
		return cumulativeCompletionT;
	}
	
	public static void main(String[] args) throws IOException {
		WeightedSumOfCompletion job = new WeightedSumOfCompletion();
		List<Jobs> diffJobList = job.computeJobDiff("/home/madhuajeeth/workspace/Java_Practice/DAA2/jobs.txt");		
		System.out.println("Weighted sum based on the difference:" + job.weightedCompletionTime(sortList1(diffJobList)));
		List<Jobs> ratioJobList = job.computeJobRatio("/home/madhuajeeth/workspace/Java_Practice/DAA2/jobs.txt");				
		System.out.println("Weighted sum based on the ratio:" + job.weightedCompletionTime(sortList2(ratioJobList)));
	}

}
