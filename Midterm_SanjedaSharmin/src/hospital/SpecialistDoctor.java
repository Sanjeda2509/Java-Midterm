package hospital;

public class SpecialistDoctor extends Doctor {

   
    private final String specialization;
    private final double specialistSurcharge;

    public SpecialistDoctor(String staffId, String name, String specialization,
                            double monthlySalary, double consultationFee,
                            int patientsSeen, double specialistSurcharge,
                            String phoneNumber) {
        super(validateSpecialist(staffId, specialization, specialistSurcharge), name, specialization + " Department",
              monthlySalary, consultationFee, patientsSeen, phoneNumber);
        this.specialization       = specialization;
        this.specialistSurcharge   = specialistSurcharge;
    }

    private static String validateSpecialist(String id, String specialization, double surcharge) {
        if (specialization == null || specialization.isBlank() ||
                !Double.isFinite(surcharge) || surcharge < 0) {
            throw new IllegalArgumentException("Invalid specialization or surcharge.");
        }
        return id;
    }

    @Override
    public double calculateConsultationFee() {
        return super.calculateConsultationFee() + specialistSurcharge;
    }

    @Override
    public double calculateMonthlyCompensation() {
        return super.calculateMonthlyCompensation() + (specialistSurcharge * 10.0);
    }

    @Override
    public void displayStaffDetails() {
        System.out.println("Staff ID        : " + getStaffId());
        System.out.println("Name            : Dr. " + getName());
        System.out.println("Specialization  : " + specialization);
        System.out.printf("Consultation Fee: $%.2f%n", calculateConsultationFee());
        System.out.printf("Monthly Comp.   : $%.2f%n", calculateMonthlyCompensation());
    }

    @Override
    public String getRoleDescription() {
        return "Specialist Doctor";
    }

    public String getSpecialization()     { return specialization; }
    public double getSpecialistSurcharge() { return specialistSurcharge; }
}
