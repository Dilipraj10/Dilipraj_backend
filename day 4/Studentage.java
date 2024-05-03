package sets;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Studentage {
	
	private int id;
	private String name;
	private int age;
	private double marks;
	
	public Studentage(int id,String name, int age,double marks) {
		
		this.id=id;
		this.name=name;
		this.age=age;
		this.marks=marks;
	}
	
	public String toString()
	{
		return this.id + " " + this.name + " " + this.age +" " + this.marks;
	}
	
	
	@Override
	public int hashCode(){
		return this.age;
	}
	
	@Override
	public boolean equals(Object s)
	{
		Studentage stu=(Studentage)s;
		return this.hashCode() == stu.hashCode();
	}

	public static void main(String[] args) {
		
		
		Scanner scan=new Scanner(System.in);
		Set<Studentage> hs = new LinkedHashSet<>();
		while(true) {
			System.out.println("enter stu id :");
			int id=scan.nextInt();
			System.out.println("enter stu name :");
			String name=scan.next();
			System.out.println("enter stu age :");
			int age=scan.nextInt();
			System.out.println("enter stu marks :");
			double  marks =scan.nextDouble();
			System.out.println("more response :");
			hs.add(new Studentage(id,name,age,marks));
			String res=scan.next();
			if(res.equalsIgnoreCase("no"))
			{
				break;
			}		
			}
		for(Studentage stu:hs) {
			System.out.println(stu);
		}

	}

}
