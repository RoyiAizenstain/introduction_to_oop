package assignment4;

// This class represents a student.
public class Student {
    // Default constructor
    public Student() {
        this.name = null;
        this.id = 0;
        this.courseReports = null;
    }

    // Constructor
    public Student(String name, int id, int numOfCourses) {
        this.name = name;
        this.id = id;
        this.courseReports = new CourseReport[numOfCourses];
    }

    // Copy constructor
    public Student(Student other) {
        this.name = other.name;
        this.id = other.id;
        // Copy course reports
        this.courseReports = new CourseReport[other.courseReports.length];
        // Iterate over all course reports
        for (int i = 0; i < other.courseReports.length; i++) {
            // If the course report is not null, copy it
            if (other.courseReports[i] != null)
                this.courseReports[i] = new CourseReport(other.courseReports[i]);
        }
    }

    // Getters and setters
    // Get the name of the student
    public String getName() {
        return this.name;
    }

    // Set the name of the student
    public void setName(String name) {
        // Set the name of the student
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    // Get the ID of the student
    public int getId() {
        return this.id;
    }

    // Set the ID of the student
    public void setId(int id) {
        this.id = id;
    }

    // Get the course reports of the student
    public CourseReport[] getCourseReports() {
        return courseReports;
    }

    // Add a course report to the student
    public void addCourse(CourseReport courseReport) {
        for (int i = 0; i < courseReports.length; i++) {
            if (courseReports[i] == null) {
                courseReports[i] = new CourseReport(courseReport);
                break;
            }
        }
    }

    // Get the weighted average of the student
    public double getWeightedAverage() {
        double sum = 0;
        double totalPoints = 0;
        // Iterate over all course reports
        for (int i = 0; i < courseReports.length; i++) {
            if (courseReports[i] != null) {
                sum += courseReports[i].getGrade() * courseReports[i].getPoints();
                totalPoints += courseReports[i].getPoints();
            }
        }
        return sum / totalPoints;
    }

    // Instance fields
    private String name;
    private int id;
    private CourseReport[] courseReports;
}
