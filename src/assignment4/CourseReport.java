package assignment4;

// This class represents a course report.
public class CourseReport {
    // Default constructor
    public CourseReport() {
        this.name = null;
        this.points = 0;
        this.grade = 0;
    }

    // Constructor
    public CourseReport(String name, int points, double grade) {
        this.name = name;
        this.points = points;
        this.grade = grade;
    }

    // Copy constructor
    public CourseReport(CourseReport other) {
        this.name = other.name;
        this.points = other.points;
        this.grade = other.grade;
    }

    // Getters and setters
    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double grade) {
        // Ensure grade is between 0 and 100
        if (grade < 0)
            grade = 0;
        else if (grade > 100)
            grade = 100;
        this.grade = grade;
    }

    public String getName() {
        // Return the name of the course
        return this.name;
    }

    public void setName(String name) {
        // Set the name of the course
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public int getPoints() {
        // Return the points of the course
        return this.points;
    }

    public void setPoints(int points) {
        // Set the points of the course
        if (points > 0)
            this.points = points;
    }

    // Instance fields
    private String name;
    private int points;
    private double grade;
}
