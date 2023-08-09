package DTO;

public class MemoDTO {
	@Override
	public String toString() {
		return "MemoDTO [idx=" + idx + ", writer=" + writer + ", memo=" + memo + ", purpose=" + purpose + ", location="
				+ location + ", attendee=" + attendee + ", conclusion=" + conclusion + ", post_date=" + post_date + "]";
	}

	private int idx;
	private String writer;
	private String memo;
	private String purpose;
	private String location;
	private String attendee;
	private String conclusion;
	private String post_date;
	
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAttendee() {
		return attendee;
	}

	public void setAttendee(String attendee) {
		this.attendee = attendee;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getPost_date() {
		return post_date;
	}

	public void setPost_date(String post_date) {
		this.post_date = post_date;
	}
	

}
