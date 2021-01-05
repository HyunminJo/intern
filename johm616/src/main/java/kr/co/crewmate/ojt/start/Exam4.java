package kr.co.crewmate.ojt.start;

public class Exam4 {
	
    public static int factorial( int n ) {
    	// 4. 입력된 자연수 n에 대한 팩토리얼 결과 값을 돌려주는 함수 factorial을 작성하세요. 가능하면 재귀함수로 작성하시오.

    	if(n <= 1) {
    		
    		return n;
    		
    	} else {
    		
    		return factorial(n-1) * n;  		    		
    	}

    }
    
}
