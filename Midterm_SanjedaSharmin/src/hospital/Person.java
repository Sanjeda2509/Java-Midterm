package hospital;

public abstract class Person {

   
    private final String personId;

    private String name;
    private String phoneNumber;

    private static int personCount = 0;


    public Person(String personId, String name, String phoneNumber) {
        if (personId == null || personId.isBlank() ||
            name == null || name.isBlank() ||
            phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Person ID, name and phone are required.");
        }
        this.personId = personId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        personCount++;           
    }


    public static int getPersonCount() {
        return personCount;
    }

  
    public String getPersonId()   { return personId; }
    public String getName()       { return name; }
    public String getPhoneNumber() { return phoneNumber; }

  
    public void displayBasicDetails() {
        System.out.println("ID    : " + personId);
        System.out.println("Name  : " + name);
        System.out.println("Phone : " + phoneNumber);
    }

   
    public abstract String getRoleDescription();

   
    @Override
    public String toString() {
        return getRoleDescription()
             + " [ID=" + personId + ", Name=" + name + ", Phone=" + phoneNumber + "]";
    }
}
