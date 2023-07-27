package dto;

public class MemberDTO {
	//ユーザー番号
	private int UserID;
	//パスワード
	private String password;
	//名前
	private String UserName;
	
	
	//コンストラクタ
	/**
	 * @param userID
	 * @param password
	 * @param userName
	 */
	public MemberDTO(int userID, String password, String userName) {
		super();
		UserID = userID;
		this.password = password;
		UserName = userName;
	}
	
	
	//	getter/setter
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	
	
	
}
