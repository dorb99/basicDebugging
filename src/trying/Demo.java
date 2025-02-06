package trying;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
//		int num = -2;
////		String str = "hello";
//		try {
			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.err.println(e);
//		}
		First.callingNext();
//		
//		System.out.println("Finished!");
		
		
	}
}

class First{
	public static void callingNext(){
		// more code	
		try {
			Second.callingNext();
		} catch (Exception e) {
			First.callingNext();
		}
		// more code
	}
}
class Second{
	public static void callingNext() throws Exception {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		try{
			System.out.println("Choose a number!");
			num = scan.nextInt();
			if(num < 0) {
				System.out.println("Number must be possitive");
				First.callingNext();
			}
		} catch(Exception e) {
//			System.out.println("Not a valid number!");
//			First.callingNext();
			scan.close();
			throw e;
		}
		System.out.println("Choosen a number! "+num);
		scan.close();
		// more code
		
		
		
		// finished and return
	}
}

class Third{
	public static int callingNext(int num) throws Exception {
		if(num < 0) {
			throw new NumberException();
		} else
		if(num == 0) {
			throw new NumberException();
//			System.err.println("received a zero");
//			return null;
		} else if (num == 15) {
			throw new Exception("The number should never be 15!");
		}
		
		System.out.println("Everything okay continue");
		
		System.out.println("worked: "+(10/num));
		// rest of code
		return num;
	}
}
class NumberException extends Exception {
	private static final long serialVersionUID = 1L;

	public NumberException() {
		super("Number isn't above 0");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}

