package board.model;

/**
 * DTO
 * 데이터를 이동시키기 위해 사용하는 객체
 * 
 * VO
 * 데이터를 정의하기 위한 객체
 */
public class BoardDto {
	private Long no;
	private String title;
	private String name;
	private String password;
	private String content;
	private String writeday;
	private Integer readcount;
	
	public Long getNo() {
		return no;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getWriteday() {
		return writeday;
	}
	
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	
	public Integer getReadcount() {
		return readcount;
	}
	
	public void setReadcount(Integer readcount) {
		this.readcount = readcount;
	}
	
	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", title=" + title + ", name=" + name + ", password=" + password + ", content="
				+ content + ", writeday=" + writeday + ", readcount=" + readcount + "]";
	}
}
