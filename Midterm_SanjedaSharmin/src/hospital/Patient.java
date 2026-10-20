package hospital;

public class Patient extends Person {


    private final String patientNumber;

    private int age;
    private String medicalDepartment;
    private double consultationFee;

    private static int patientCount = 0;


    public Patient(String patientNumber, String name, int age,
                   String department, String phoneNumber) {
        super(validatePatientNumber(patientNumber, age, department), name, phoneNumber);  
        this.patientNumber   = patientNumber;
        this.age             = age;
        this.medicalDepartment = department;
        this.consultationFee  = 0.0;
        patientCount++;                           
    }

    private static String validatePatientNumber(String number, int age, String department) {
        if (age <= 0 || age > 120 || department == null || department.isBlank()) {
            throw new IllegalArgumentException("Invalid patient age or department.");
        }
        return number;
    }

    public static int getPatientCount() {
        return patientCount;
    }

    
    @Override
    public String getRoleDescription() {
        return "Patient";
    }

    public void setConsultationFee(double fee) {
        if (fee >= 0) {
            this.consultationFee = fee;
        } else {
            System.out.println("Invalid consultation fee -- keeping previous value.");
        }
    }

    public double getConsultationFee()  { return consultationFee; }
    public String getPatientNumber()    { return patientNumber; }
    public int    getAge()              { return age; }
    public String getMedicalDepartment(){ return medicalDepartment; }

    public void displayPatientDetails() {
        System.out.println("Patient Number : " + patientNumber);
        displayBasicDetails();
        System.out.println("Age            : " + age);
        System.out.println("Department     : " + medicalDepartment);
        System.out.printf("Consultation Fee: $%.2f%n", consultationFee);
    }

   
    public static Patient registerPatient(String name, int age) {
        return registerPatient(name, age, "General Medicine");
    }

   
    public static Patient registerPatient(String name, int age, String department) {
       
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Registration FAILED: name cannot be empty.");
            return null;
        }
        if (age <= 0 || age > 120) {
            System.out.println("Registration FAILED: invalid age " + age + ".");
            return null;
        }
        if (department == null || department.trim().isEmpty()) {
            System.out.println("Registration FAILED: department cannot be empty.");
            return null;
        }

        
        String pNum = "P" + (1000 + patientCount + 1);
        Patient p = new Patient(pNum, name, age, department, "N/A");
        System.out.println("Registration SUCCESSFUL for patient: " + name
                         + " (" + pNum + ", " + department + ")");
        return p;
    }
}
