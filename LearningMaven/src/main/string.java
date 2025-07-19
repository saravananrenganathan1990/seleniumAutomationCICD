package main;

public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String a = "Jai Hind India";
String[] s = a.split("Hind");
System.out.println(s[0]);
System.out.println(s[1].trim());


System.out.println("****************Forward order");
String[] s1 = a.split("");
for (String name:s1) {
	System.out.println(name);
}
System.out.println("****************Reverse order"); 

for (int i=a.length()-1;i>=0;i--) {
	System.out.println(a.charAt(i));
}
	}

}
