package br.gov.sp.fatec.model;

public class MessageTest {
	
	private String name;
	
	private Integer number;
	
	private String info;
	
	public MessageTest() {
		// TODO Auto-generated constructor stub
	}

	public MessageTest(String name, Integer number, String info) {
		super();
		this.name = name;
		this.number = number;
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "MessageTest [name=" + name + ", number=" + number + ", info=" + info + "]";
	}
	
}
