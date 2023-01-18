import java.io.Serializable;

public class Employee implements Cloneable, Serializable {


    private int empID;
    private String empName;
    private String empDepartment;


    public Employee(){}
    private Employee(int empID){
        this.empID = empID;
    }

    public Employee(int empID, String empName, String empDepartment) {
        this.empID = empID;
        this.empName = empName;
        this.empDepartment = empDepartment;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }
}
