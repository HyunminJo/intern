package kr.co.crewmate.ojt.start;

public class Exam5 {
	
	    public static String reverse(String s) {
	    	// 5. 입력된 문자열 s의 앞-뒤를 뒤집은 문자열을 돌려주는 함수 reverse를 작성하세요. (입력예: ABCDEF / 출력예: FEDCBA)

	    	if(s.length() == 0)
	            return "";
	    	
	        else{
	        	return reverse(s.substring(1)) + s.charAt(0);
	        	
	        }
			
	    }

}
