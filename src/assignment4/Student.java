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
        if (other == null) {
            this.name = null;
            this.id = 0;
            this.courseReports = null;
        } else {
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
        if(courseReport == null) {
            return;
        }
        for (int i = 0; i < courseReports.length; i++) {
            if (courseReports[i] == null) {
                courseReports[i] = new CourseReport(courseReport);
                break;
            }
        }
    }

    public double getTotalPoints() {
        double totalPoints = 0;
        // Iterate over all course reports
        for (int i = 0; i < courseReports.length; i++) {
            if (courseReports[i] != null) {
                totalPoints += courseReports[i].getPoints();
            }
        }
        return totalPoints;
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

    public boolean equals(Student other) {
        if (other == null) {
            return false;
        }
        // Iterate over all course reports
        Boolean sameCourseReports = true;
        int counti = 0;
        int countj = 0;
        // Iterate over all course reports
        for (int i = 0; i < this.courseReports.length; i++) {
            if (this.courseReports[i] == null) {
                continue;
            }
            counti++;
            for (int j = 0; j < other.courseReports.length; j++) {
                if (other.courseReports[j] == null) {
                    continue;
                }
                if (other.courseReports[j].equals(this.courseReports[i])) {
                    countj++;
                }
            }
        }
        return this.name.equals(other.name) && this.id == other.id && counti == countj;
    }

    public String toString() {
        // Iterate over all course reports
        String courseReportsOutput = "[";
        for (int i = 0; i < courseReports.length; i++) {
            if (courseReports[i] != null && i < courseReports.length - 1 && courseReports[i + 1] != null) {
                courseReportsOutput += courseReports[i].toString() + ", ";
            } else if (courseReports[i] != null) {
                courseReportsOutput += courseReports[i].toString();
            }
        }
        return this.name + ": " + this.id + " " + courseReportsOutput + "]";
    }

    // Instance fields
    private String name;
    private int id;
    private CourseReport[] courseReports;
}
