import java.util.Scanner;

class Course {
    private String courseName;
    private String duration;

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDuration() {
        return duration;
    }
}

class Student {
    private String name;
    protected Course enrolledCourse;

    public Student(String name, Course enrolledCourse) {
        this.name = name;
        this.enrolledCourse = enrolledCourse;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student: " + name +
               " Course: " + enrolledCourse.getCourseName() +
               " (" + enrolledCourse.getDuration() + ")";
    }
}

class PremiumStudent extends Student {
    private double discount;

    public PremiumStudent(String name, Course enrolledCourse, double discount) {
        super(name, enrolledCourse);
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Premium Student: " + getName() +
               " Course: " + enrolledCourse.getCourseName() +
               " (" + enrolledCourse.getDuration() + ")" +
               " Discount: " + discount + "%";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Course input
        String[] courseData = sc.nextLine().split(",");
        String courseName = courseData[0].trim();
        String duration = courseData[1].trim();

        Course course = new Course(courseName, duration);

        // Normal Student input
        String[] studentData = sc.nextLine().split(",");
        String studentName = studentData[0].trim();

        Student student = new Student(studentName, course);

        // Premium Student input
        String[] premiumData = sc.nextLine().split(",");
        String premiumName = premiumData[0].trim();
        double discount = Double.parseDouble(premiumData[2].trim());

        PremiumStudent premiumStudent =
                new PremiumStudent(premiumName, course, discount);

        System.out.println(student);
        System.out.println(premiumStudent);

        sc.close();
    }
}