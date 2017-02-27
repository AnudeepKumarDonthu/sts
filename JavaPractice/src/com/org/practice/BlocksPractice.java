package com.org.practice;

/**
 * @author Anudeep Kumar
 *
 */
class A {

	static {
		System.out.println("I am in A class Static block");
	}
	{
		System.out.println("I am in A class normal block");
	}
}

class B  extends A{

	static {
		System.out.println("I am in B class Static block");
	}
	{
		System.out.println("I am in B class normal block");
	}
}
public class BlocksPractice {

	/**
	 * @param args
	 */
	int i;
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.totalMemory());
		System.out.println(rt.maxMemory());
		BlocksPractice bp = new BlocksPractice();
		System.out.println(bp.i);
		A a = new A();
		B b = new B();
		A c = new B();
		B d = new B();
		A e = new B();
		boolean f =true;
		Boolean g = new Boolean(args[0]);
		Integer h=new Integer(10);
		Integer i=new Integer(10);
		int j =h.intValue();
		String k = new String("anudeep");
		String l = new String("anudeep");
		String m = "anudeep";
		String n = new String("kumar");
		String o = new String("donthu");
		System.out.println("String k="+k.toString()+" hashcode value "+k.hashCode());
		System.out.println("String l="+l+" hashcode value "+l.hashCode());
		System.out.println("String m="+m+" hashcode value "+m.hashCode());
		System.out.println("String n="+n+" hashcode value "+n.hashCode());
		System.out.println("String o="+o+" hashcode value "+o.hashCode());
		System.out.println(h.hashCode());
		System.out.println(i.hashCode());
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(g);
		System.out.println(rt.freeMemory());
		System.gc();
		System.out.println(rt.freeMemory());
	}

}
