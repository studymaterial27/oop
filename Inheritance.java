
class Employee
{
private String Emp_name;
private String Emp_id;
private String Address;
private String Mail_id;
private String Mobile_no;

public Employee(String Emp_name, String Emp_id, String Address, String Mail_id, String Mobile_no)
{
this. Emp_name = Emp_name;
this. Emp_id = Emp_id;
this. Address = Address;
this. Mail_id = Mail_id;
this.Mobile_no = Mobile_no;
}

public void displayEmployeeDetails()
{
System.out.println("Employee ID: " + Emp_id);
System.out.println("Name: " + Emp_name);
System.out.println("Address: " + Address);
System.out.println("Email: " + Mail_id);
System.out.println("Mobile: " + Mobile_no);
}
}

class Programmer extends Employee
{
private double basicPay;
public Programmer(String Emp_name, String Emp_id, String Address, String Mail_id, String Mobile_no, double basicPay)
{
super(Emp_name, Emp_id, Address, Mail_id, Mobile_no);
this.basicPay = basicPay;
}

public void generatePaySlip()
{
System.out.println("Basic Pay: " + basicPay);
double da = 0.97 * basicPay;
System.out.println("DA: " + da);
double hra = 0.10 * basicPay;
System.out.println("HRA: " + hra);
double pf = 0.12 * basicPay;
System.out.println("PF: " + pf);
double staffClubFund = 0.001 * basicPay;
System.out.println("Staff Club Fund: " + staffClubFund);
double grossSalary = basicPay + da + hra;
System.out.println("Gross Salary: " + grossSalary);
double netSalary = grossSalary - pf - staffClubFund;
System.out.println("Net Salary: " + netSalary);

}
}

class TeamLead extends Employee
{
private double basicPay;

public TeamLead(String Emp_name, String Emp_id, String Address, String Mail_id, String Mobile_no, double basicPay)
{
super(Emp_name, Emp_id, Address, Mail_id, Mobile_no);
this.basicPay = basicPay;
}

public void generatePaySlip()
{
System.out.println("Basic Pay: " + basicPay);
double da = 0.97 * basicPay;
System.out.println("DA: " + da);
double hra = 0.10 * basicPay;
System.out.println("HRA: " + hra);
double pf = 0.12 * basicPay;
System.out.println("PF: " + pf);
double staffClubFund = 0.001 * basicPay;
System.out.println("Staff Club Fund: " + staffClubFund);
double grossSalary = basicPay + da + hra;
System.out.println("Gross Salary: " + grossSalary);
double netSalary = grossSalary - pf - staffClubFund;
System.out.println("Net Salary: " + netSalary);

}
}

class AssistantProjectManager extends Employee
{
private double basicPay;

public AssistantProjectManager(String Emp_name, String Emp_id, String Address, String Mail_id, String Mobile_no, double basicPay)
{
super(Emp_name, Emp_id, Address, Mail_id, Mobile_no);
this.basicPay = basicPay;
}

public void generatePaySlip()
{
System.out.println("Basic Pay: " + basicPay);
double da = 0.97 * basicPay;
System.out.println("DA: " + da);
double hra = 0.10 * basicPay;
System.out.println("HRA: " + hra);
double pf = 0.12 * basicPay;
System.out.println("PF: " + pf);
double staffClubFund = 0.001 * basicPay;
System.out.println("Staff Club Fund: " + staffClubFund);
double grossSalary = basicPay + da + hra;
System.out.println("Gross Salary: " + grossSalary);
double netSalary = grossSalary - pf - staffClubFund;
System.out.println("Net Salary: " + netSalary);

}
}

class ProjectManager extends Employee
{
private double basicPay;
public ProjectManager(String Emp_name, String Emp_id, String Address, String Mail_id, String Mobile_no, double basicPay)
{
super(Emp_name, Emp_id, Address, Mail_id, Mobile_no);
this.basicPay = basicPay;
}

public void generatePaySlip()
{
System.out.println("Basic Pay: " + basicPay);
double da = 0.97 * basicPay;
System.out.println("DA: " + da);
double hra = 0.10 * basicPay;
System.out.println("HRA: " + hra);
double pf = 0.12 * basicPay;
System.out.println("PF: " + pf);
double staffClubFund = 0.001 * basicPay;
System.out.println("Staff Club Fund: " + staffClubFund);
double grossSalary = basicPay + da + hra;
System.out.println("Gross Salary: " + grossSalary);
double netSalary = grossSalary - pf - staffClubFund;
System.out.println("Net Salary: " + netSalary);

}
}

public class Main {
public static void main(String[] args)
{
Programmer programmer = new Programmer("Amit", "1001", "Pune","amit@mail.com", "1234567890", 50000);
TeamLead teamLead = new TeamLead("Puja", "1002", "Sangamner", "puja@mail.com","0987654321", 70000);
AssistantProjectManager apm = new AssistantProjectManager("Anay", "1003","Mumbai", "anay@mail.com", "1112223333", 90000);
ProjectManager pm = new ProjectManager("Bob", "1004", "Nashik", "bob@mail.com","4445556666", 120000);

System.out.println("****Information of Programmer****");
programmer.displayEmployeeDetails();
programmer.generatePaySlip();
System.out.println();
System.out.println("****Information of Team Lead****");
teamLead.displayEmployeeDetails();
teamLead.generatePaySlip();
System.out.println();
System.out.println("****Information of Assistant Project Manager****");
apm.displayEmployeeDetails();
apm.generatePaySlip();
System.out.println();

System.out.println("****Information of Project Manager****");
pm.displayEmployeeDetails();
pm.generatePaySlip();
}
}

