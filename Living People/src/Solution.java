public class Solution{
	public static void main(String[] args){
		Span[] input = {new Span(1912,1955),new Span(1920,1990),new Span(1910,1998), new Span(1901,1972),new Span(1910,1998),new Span(1923,1982),new Span(1913,1998) };
		System.out.println(maxLiving(input));
	}
	//****This method is O(PY)*******
//	public static int mostLiving(Span[] record){
//		int year = 0;
//		if(record.length==0){
//			return year;
//		}
//		else{
//			int[] result = new int[101];
//			int index = 1900;
//			int max = 0;
//			for(Span x : record){
//				for(int i = x.birth; i<=x.dead; i++){
//					int cand = result[i-1900]++;
//					if(cand>max){
//						index = i;
//						max = cand;
//					}
//				}
//			}
//			return index;
//		}
//	}
	//****New method with O(P+Y)****
	public static int maxLiving(Span[] record){
		int[] people = new int[101];
		for(Span x : record){
			people[x.birth-1900]++;
			people[x.dead-1900+1]--;
		}
		int max = 0;
		int year = 1900;
		int count = 0;
		for(int i = 0; i<people.length; i++){
			count += people[i];
			if(count>max){
				year = 1900+i;
				max = count;
			}
		}
		return year;
	}
}
