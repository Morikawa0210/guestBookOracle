package DTO;

public class GuestBookDTO {
	private int idx;
	private String name;
	private String email;
	private String content;
	private String post_date;
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}

	@Override
	public String toString() {
		return "GuestBookDTO [idx=" + idx + ", name=" + name + ", email=" + email + ", content=" + content
				+ ", post_date=" + post_date + "]";
	}
	
	

}
