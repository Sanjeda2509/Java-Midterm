package hospital;

public class Nurse extends MedicalStaff {

  
    private final String shiftType;
    private final double shiftAllowance;

    public Nurse(String staffId, String name, String department,
                 double monthlySalary, String shiftType,
                 double shiftAllowance, String phoneNumber) {
        super(validateNurse(staffId, shiftType, shiftAllowance), name, department, monthlySalary, phoneNumber);
        this.shiftType      = shiftType;
        this.shiftAllowance = shiftAllowance;
    }

    private static String validateNurse(String id, String shift, double allowance) {
        if (shift == null || shift.isBlank() || !Double.isFinite(allowance) || allowance < 0) {
            throw new IllegalArgumentException("Invalid nurse shift or allowance.");
        }
        return id;
    }

    @Override
    public double calculateMonthlyCompensation() {
        return getMonthlySalary() + shiftAllowance;
    }

    @Override
    public void displayStaffDetails() {
        System.out.println("Staff ID        : " + getStaffId());
        System.out.println("Name            : " + getName());
        System.out.println("Department      : " + getDepartment());
        System.out.println("Shift           : " + shiftType);
        System.out.printf("Monthly Comp.   : $%.2f%n", calculateMonthlyCompensation());
    }

    @Override
    public String getRoleDescription() {
        return "Nurse";
    }

    public String getShiftType()      { return shiftType; }
    public double getShiftAllowance() { return shiftAllowance; }
}
