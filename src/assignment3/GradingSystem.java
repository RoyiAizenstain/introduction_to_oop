package assignment3;

// This class represents a grading system.
public class GradingSystem {
    // Default constructor
    public GradingSystem() {
        this.name = null;
        this.students = null;
    }

    // Constructor
    public GradingSystem(String name, int studentCount) {
        this.name = name;
        this.students = new Student[studentCount];
    }

    // Copy constructor
    public GradingSystem(GradingSystem other) {
        this.name = other.name;
        this.students = other.students.clone();
    }

    // Getters and setters

    // Get the name of the grading system
    public String getName() {
        // Return the name of the grading system
        return this.name;
    }

    // Set the name of the grading system
    public void setName(String name) {
        this.name = name;
    }

    // Get the students in the grading system
    public Student[] getStudents() {
        return students;
    }

    // Add a student to the grading system
    public void addStudent(Student student) {
        // Iterate over all students
        for (int i = 0; i < students.length; i++) {
            // If the student is null, add the student to the array
            if (students[i] == null) {
                students[i] = new Student(student);
                break;
            }
        }
    }

    public double getAverage() {
        // Get the average weighted average of all students
        double sum = 0;
        double totalStudents = 0;
        // Iterate over all students
        for (int i = 0; i < students.length; i++) {
            // If the student is not null, add their weighted average to the sum
            if (students[i] != null) {
                sum += students[i].getWeightedAverage();
                totalStudents++;
            }
        }
        return sum / totalStudents;
    }

    // Instance fields
    private String name;
    private Student[] students;
}
