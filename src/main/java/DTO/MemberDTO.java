package DTO;

public class MemberDTO {
	private String idx;
	private String password;
	private String name;
	
	public MemberDTO(String idx, String password) {
		super();
		this.idx = idx;
		this.password = password;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

	

}
