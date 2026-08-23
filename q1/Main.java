import java.util.*;

class Professor {
    private String name;
    private String employeeId;
    private String specialization;

    // Default constructor
    public Professor() {
    }

    // Parameterized constructor
    public Professor(String name, String employeeId, String specialization) {
        this.name = name;
        this.employeeId = employeeId;
        this.specialization = specialization;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // toString()
    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + employeeId
                + ", Specialization: " + specialization;
    }
}

class Department {
    private String deptName;
    private String hodName;
    private List<Professor> professors;

    // Default constructor
    public Department() {
        professors = new ArrayList<>();
    }

    // Parameterized constructor
    public Department(String deptName, String hodName) {
        this.deptName = deptName;
        this.hodName = hodName;
        professors = new ArrayList<>();
    }

    // Getters and Setters
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    // Add professor
    public void addProfessor(Professor p) {
        professors.add(p);
    }

    // toString()
    @Override
    public String toString() {
        String result = "Department: " + deptName +
                "\nHOD: " + hodName +
                "\nProfessors:\n";

        for (Professor p : professors) {
            result += p + "\n";
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Department details
        System.out.println("Enter Department details (deptName,hodName)");
        String[] dept = sc.nextLine().split(",");

        Department department = new Department(dept[0], dept[1]);

        // Number of professors
        System.out.println("Enter number of professors");
        int n = Integer.parseInt(sc.nextLine());

        // Professor details
        System.out.println("Enter professor details (name,employeeId,specialization)");

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(",");

            Professor professor = new Professor(
                    data[0],
                    data[1],
                    data[2]
            );

            department.addProfessor(professor);
        }

        // Output
        System.out.println(department);

        sc.close();
    }
}