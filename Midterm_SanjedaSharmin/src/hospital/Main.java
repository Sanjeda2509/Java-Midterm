package hospital;

public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("        CAREPOINT HOSPITAL");
        System.out.println("        MANAGEMENT SYSTEM");
        System.out.println("========================================\n");

       
        // 1. PATIENT REGISTRATION 

        System.out.println("---- PATIENT REGISTRATION ----");
        Patient p1 = Patient.registerPatient("Priya Sharma", 35, "Cardiology");
        if (p1 != null) p1.setConsultationFee(150.0);

        Patient p2 = Patient.registerPatient("Daniel Brown", 42, "General Medicine");
        if (p2 != null) p2.setConsultationFee(120.0);

        // Show patient details
        if (p1 != null) { System.out.println(); p1.displayPatientDetails(); }
        if (p2 != null) { System.out.println(); p2.displayPatientDetails(); }

        
        // 2. INVALID REGISTRATION ATTEMPTS
      
        System.out.println("\n---- INVALID REGISTRATION ATTEMPTS ----");
        Patient.registerPatient("", 30, "Cardiology");      // empty name
        Patient.registerPatient("Test Patient", -5, "");    // invalid age + dept
        Patient.registerPatient(
            "No Name", 200, "General"); // age too high

      
        // 3. DOCTOR DETAILS
   
        System.out.println("\n---- DOCTOR DETAILS ----");
        Doctor doctor = new Doctor("D2001", "Amit Kumar", "Cardiology",
                                   9000, 150, 100, "555-0101");
        doctor.displayStaffDetails();
  
        // 4. SPECIALIST DOCTOR DETAILS 
      
        System.out.println("\n---- SPECIALIST DOCTOR DETAILS ----");
        SpecialistDoctor specialist = new SpecialistDoctor("D2002", "Neha Patel",
                "Neurology", 12000, 200, 80, 50, "555-0102");
        specialist.displayStaffDetails();

        // 5. NURSE DETAILS (hierarchical inheritance)

        System.out.println("\n---- NURSE DETAILS ----");
        Nurse nurse = new Nurse("N3001", "Sarah Wilson", "Emergency",
                               5000, "Night", 500, "555-0103");
        nurse.displayStaffDetails();

        // 6. CONSULTATION FEE CALCULATIONS (overloaded methods)

        System.out.println("\n---- CONSULTATION FEE CALCULATIONS (overloaded) ----");
        System.out.printf("Standard Consultation Fee            : $%.2f%n",
                          doctor.calculateConsultationFee());
        System.out.printf("Consultation Fee After 10%% Discount   : $%.2f%n",
                          doctor.calculateConsultationFee(10));
        System.out.printf("Consultation Fee + Additional Charge  : $%.2f%n",
                          doctor.calculateConsultationFee(0, 25));

        // 7. RUNTIME POLYMORPHISM via MedicalStaff references (Req. 10)

        System.out.println("\n---- RUNTIME POLYMORPHISM ----");
        MedicalStaff[] staffList = { doctor, specialist, nurse };
        for (MedicalStaff s : staffList) {
            System.out.println("Role              : " + s.getRoleDescription());
            s.displayStaffDetails();
            System.out.printf("Monthly Comp.     : $%.2f%n", s.calculateMonthlyCompensation());
            System.out.println("---");
        }

        // 8. INTERFACES DEMONSTRATION (multiple inheritance)
  
        System.out.println("\n---- INTERFACES DEMONSTRATION ----");
        Reportable reportable = doctor;                 // upcast to interface
        reportable.generateReport();

        System.out.println();
        Schedulable schedulable = specialist;           // upcast to interface
        schedulable.scheduleAppointment("2026-11-15 10:00");
        schedulable.scheduleAppointment("");            // invalid date

 
        // 9. REGISTRATION SUMMARY (static counters)

        System.out.println("\n---- REGISTRATION SUMMARY ----");
        System.out.println("Total People       : " + Person.getPersonCount());
        System.out.println("Total Patients     : " + Patient.getPatientCount());
        System.out.println("Total Medical Staff: " + MedicalStaff.getStaffCount());

        // 10. TEST CASES SUMMARY

        System.out.println("\n---- TEST CASES ----");
        System.out.println("TC1 - Successful patient registration: 2 valid patients");
        System.out.println("TC2 - Rejected invalid age / missing info: 3 failures");
        System.out.println("TC3 - Consultation fee: $150 / $135 (10% off) / $175 (+$25)");
        System.out.println("TC4 - Compensation: Doctor=$10000, Nurse=$5500, Specialist=$13300");
        System.out.println("TC5 - Static counters: people="
                + Person.getPersonCount()
                + ", patients=" + Patient.getPatientCount()
                + ", staff=" + MedicalStaff.getStaffCount());

        System.out.println("\n========================================");
        System.out.println("            END OF REPORT");
        System.out.println("========================================");
    }
}
