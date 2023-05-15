package oop02.static03;

public class PersonTest {
	public static void main(String[] args) {
		Person p1 = new Person("최동철", "Korean");
		Person p2 = new Person("홍은성", "Korean");
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		p1.setName("권욱헌");
		p2.setNation("중국인");
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}
}
