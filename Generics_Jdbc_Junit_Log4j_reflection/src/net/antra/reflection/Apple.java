package net.antra.reflection;

public class Apple {
	
	private String color;
	public int aPublicVar;
	
	public Apple(){
		color = "red";
	}
	
	public void aPublicMethod(){
		System.out.println("aPublicMethod is called");
	}
	
	private void aPrivateMethod(){
		System.out.println("aPrivateMethod is called");
	}

	protected void aProtectedMethod(){
		System.out.println("aProtectedMethod is called");
	}
}
