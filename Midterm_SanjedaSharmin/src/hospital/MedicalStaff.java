package hospital;

public abstract class MedicalStaff extends Person {

    
    private final String staffId;

    private String department;
    private double monthlySalary;

    private static int staffCount = 0;

    public MedicalStaff(String staffId, String name, String department,
                        double monthlySalary, String phoneNumber) {
        super(validateStaff(staffId, department, monthlySalary), name, phoneNumber);
        this.staffId       = staffId;
        this.department    = department;
        this.monthlySalary = monthlySalary;
        staffCount++;                          
    }

    private static String validateStaff(String id, String department, double salary) {
        if (department == null || department.isBlank() ||
                !Double.isFinite(salary) || salary < 0) {
            throw new IllegalArgumentException("Invalid department or monthly salary.");
        }
        return id;
    }

    public static int getStaffCount() {
        return staffCount;
    }

    public String getStaffId()    { return staffId; }
    public String getDepartment() { return department; }
    public double getMonthlySalary() { return monthlySalary; }

 
    public abstract double calculateMonthlyCompensation();

   
    public void displayStaffDetails() {
        System.out.println("Staff ID        : " + staffId);
        displayBasicDetails();
        System.out.println("Department      : " + department);
        System.out.printf("Monthly Salary  : $%.2f%n", monthlySalary);
    }

    @Override
    public String getRoleDescription() {
        return "Medical Staff";
    }
}
