package hospital;

public class Doctor extends MedicalStaff implements Reportable, Schedulable {

    
    private final double consultationFee;

    private int patientsSeen;

    public Doctor(String staffId, String name, String department,
                  double monthlySalary, double consultationFee,
                  int patientsSeen, String phoneNumber) {
        super(validateDoctor(staffId, consultationFee, patientsSeen), name, department, monthlySalary, phoneNumber);
        this.consultationFee = consultationFee;
        this.patientsSeen    = patientsSeen;
    }


    private static String validateDoctor(String id, double fee, int patientsSeen) {
        if (!Double.isFinite(fee) || fee < 0 || patientsSeen < 0) {
            throw new IllegalArgumentException("Invalid consultation fee or patient count.");
        }
        return id;
    }

    @Override
    public double calculateMonthlyCompensation() {
        double performanceAllowance = patientsSeen * 10.0;
        return getMonthlySalary() + performanceAllowance;
    }

  
    @Override
    public void displayStaffDetails() {
        System.out.println("Staff ID        : " + getStaffId());
        System.out.println("Name            : Dr. " + getName());
        System.out.println("Department      : " + getDepartment());
        System.out.printf("Monthly Salary  : $%.2f%n", getMonthlySalary());
        System.out.println("Patients Seen   : " + patientsSeen);
        System.out.printf("Consultation Fee: $%.2f%n", consultationFee);
        System.out.printf("Monthly Comp.   : $%.2f%n", calculateMonthlyCompensation());
    }

    @Override
    public String getRoleDescription() {
        return "Doctor";
    }

  
    public double calculateConsultationFee() {
        return consultationFee;
    }

 
    public double calculateConsultationFee(double discount) {
        if (!Double.isFinite(discount) || discount < 0 || discount > 100) {
            System.out.println("Invalid discount. Using standard fee.");
            return consultationFee;
        }
        return consultationFee - (consultationFee * discount / 100.0);
    }

    public double calculateConsultationFee(double discount, double additionalCharge) {
        if (!Double.isFinite(discount) || !Double.isFinite(additionalCharge) || discount < 0 || discount > 100 || additionalCharge < 0) {
            System.out.println("Invalid input. Using standard fee.");
            return consultationFee;
        }
        double base = consultationFee - (consultationFee * discount / 100.0);
        return base + additionalCharge;
    }

    @Override
    public void generateReport() {
        System.out.println("---- Doctor Report ----");
        displayStaffDetails();
    }

    @Override
    public void scheduleAppointment(String appointmentDate) {
        if (appointmentDate == null || appointmentDate.trim().isEmpty()) {
            System.out.println("Appointment scheduling FAILED: invalid date.");
        } else {
            System.out.println("Appointment scheduled with Dr. " + getName()
                             + " on " + appointmentDate);
        }
    }

    public double getConsultationFee() { return consultationFee; }
    public int    getPatientsSeen()    { return patientsSeen; }
}
