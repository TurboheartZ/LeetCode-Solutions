import java.util.Arrays;
import java.util.stream.Stream;
import java.util.*;
import java.util.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] test = {1,2,3,4,6,5};
//		Arrays.sort(test);
//		System.out.println(Arrays.toString(test));
//		Comparator<Integer> comp = new Comparator<Integer>(){
//			@Override
//			public int compare(Integer a, Integer b){
//				return a==b?0:a<b?1:-1;
//			}
//		};
//		Arrays.sort(test,comp);
//		System.out.println(Arrays.toString(test));
		Student a = new Student(18,"Mark");
		Student b = new Student(19,"Lily");
		Student c = new Student(20,"Lucy");
		Student[] test = {a,b,c};
//		Arrays.sort(test,( x,  y) -> x.age==y.age?0:x.age>y.age?-1:1);
//		for(int i = 0; i<test.length; i++){
//			System.out.printf("%s\n",test[i].name);
//		}
//		
//		List<Student> lis = Arrays.asList(test);
//		Stream<Student> studentStream = Stream.of(a,b,c);
//		Stream<Student> studentStream2 = Stream.of(a,b,c);
//		int sum = 0;   
//		long startTime1 = System.nanoTime();
//		System.out.println(studentStream.map(stu -> stu.age>17?stu.age:0).reduce(0,(x,y)->x+y));
//		long endTime1 = System.nanoTime();
//		System.out.println(endTime1-startTime1);
//		long startTime2 = System.nanoTime();
//		studentStream2.filter(stud->stud.age>17);
//		//System.out.println(sum);
//		long endTime2 = System.nanoTime();
//		System.out.println(endTime2-startTime2);
		newStudent d = new newStudent(11,"Frank");
		System.out.printf("%d\t%s", d.getAge(),d.name);
	}

}
