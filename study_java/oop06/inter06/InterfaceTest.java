package oop06.inter06;

public class InterfaceTest {
	public static void main(String[] args) {
		InterImpl impl = new InterImpl();
		impl.methodC(); // 전부 실행 가능
		
		InterfaceA ia = impl;
		ia.methodA(); // A만 실행 가능
		
		InterfaceB ib = impl;
		ib.methodB(); // B만 실행 가능
		
		InterfaceC ic = impl;
		ic.methodC(); // 전부 실행 가능
	}
}
