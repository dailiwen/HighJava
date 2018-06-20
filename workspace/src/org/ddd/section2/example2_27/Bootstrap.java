package org.ddd.section2.example2_27;

public class Bootstrap {
	public static void main(String[] args) {
		Manager manager = new Manager();
		if(manager instanceof Employee){
			System.out.println("经理也是员工！");
		}else{
			System.out.println("经理不是员工！");
		}
	}
}





