package test;

public class MemberService {


	boolean login(String id, String pwd) {
		if(id.equals("hong") && pwd.equals("12345")){
			return true;
		} else {
			return false;
		}
	}
	
	void logout(String id){
		System.out.println("로그아웃되었습니다.");
	}
}
