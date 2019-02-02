package hackerrank;
import hackerrank.Node;
import hackerrank.BST_check;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import hackerrank.AVL_check;

public class test {
	
	static int[] bigestRange(int[] arr){
		int[] days = new int[2];
		int maxRange = 0;
		for(int day = 0; day < arr.length; day++) {
			for(int day2 = day + 1; day2 < arr.length; day2++) {
				if(arr[day2] - arr[day] > maxRange) {days[0] = day; days[1] = day2; maxRange = arr[day2] - arr[day];}
				else if(arr[day2] - arr[day] == maxRange && day2 - day < days[1] - days[0]) {days[0] = day; days[1] = day2; maxRange = arr[day2] - arr[day];}
			}
		}
		return days;
	}
	
	static int[] loto(int[] arr) {
		int[] randomArr = new int[6];
		int randInd = 0;
		int arrInd;
		while(randInd < 6) {
			arrInd = ThreadLocalRandom.current().nextInt(0, arr.length);
			if(!Arrays.asList(randomArr).contains(arr[arrInd])){randomArr[randInd] = arr[arrInd]; randInd++;}
			}
		return randomArr;
	}
    static int Add(int x, int y) 
    { 
        // Iterate till there is no carry 
        while (y != 0)  
        { 
            // carry now contains common 
            // set bits of x and y 
            int carry = x & y; 
  
            // Sum of bits of x and  
            // y where at least one  
            // of the bits is not set 
            x = x ^ y; 
  
            // Carry is shifted by  
            // one so that adding it  
            // to x gives the required sum 
            y = carry << 1; 
        } 
        return x; 
    } 
    
    static void fibonuchi(int x) {
    	HashMap<Integer, Long> memo = new HashMap<Integer, Long>();
    	fibonuchi(x, memo);
    }
    static void fibonuchi(int x, HashMap<Integer, Long> memo) {
    	for(int i = 1; i <= x; i++) {
    		if (i < 3){
    			memo.put(i, Long.valueOf(1));
    			System.out.println(1);
    			}
    		else {
    			memo.put(i, memo.get(i-2) + memo.get(i-1));
    			System.out.println(memo.get(i));
    		}
    	}
    	
    }
    
    
	public static void main(String[] args) {
		System.out.print(Math.round(43 * Math.random()));
		
		
//		int x = 17;
//		for(int i = -x; i <= x; i++) {
//			if(i < 0) {
//				System.out.println(new String(new char[x+i]).replace("\0", " ") + "\\" + new String(new char[-i]).replace("\0", "  ") + "/");
//			}
//			else if(i > 0) {
//				System.out.println(new String(new char[x-i]).replace("\0", " ") + "/" + new String(new char[i]).replace("\0", "  ") + "\\");
//			}
//			else {
//				System.out.println(new String(new char[x]).replace("\0", " ") + "\\" + new String(new char[i]).replace("\0", " ") + "/");
//				System.out.println(new String(new char[x]).replace("\0", " ") + "/" + new String(new char[i]).replace("\0", " ") + "\\");
//			}
//		}
		
		
		
//		Node root = new Node(10);
//		Node node1 = new Node(5);
//		Node node2 = new Node(20);
//		Node node3 = new Node(15);
//		Node node4 = new Node(17);
//		Node node5 = new Node(4);
//		Node node6 = new Node(50);
//		Node node7 = new Node(2);
//		Node node8 = new Node(6);
//		root.left = node1;
//		root.right = node2;
//		node2.left = node3;
//		node2.right = node6;
//		node3.right = node4;
//		node1.left = node5;
//		node1.right = node8;
//		node5.left = node7;
//		
//		System.out.println(AVL_check.findTheElementX(root, 17));

	}
}
