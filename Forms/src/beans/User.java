package beans;
// 자바 빈으로 만들 클래스 (필드변수, 기본 생성자(생략가능), get/set 메소드 필요)
public class User {
	private String email = "";
	private String password = "";
	
	private String message = ""; // 유효성 검사에 불합격 했을때 메세지
		
	public User() {
		//기본 생성자
	}
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// 입력된 필드변수들의 값이 유효한지 유효성 검사
	public boolean validate() {
							//정규 표현식으로 자바문자열은 \\역슬레쉬를 두번 적어야한다. \w+ 모든문자(숫자포함)		
		if(!email.matches("\\w+@\\w+\\.\\w+")) {
			message = "Invalid email";
			return false;
		}		
		if(password.length() < 8) {
			message = "패스워드는 8자 이상";
			return false;
		}
		else if(password.matches("\\w*\\s+\\w*")) {
			message = "패스워드에 스페이스가 포함되면 안됩니다.";
			return false;	
		}
		// 위의 검사들을 다 합격하면 유효성 메소드 true로 리턴한다.
		return true;
	}
	
}
















