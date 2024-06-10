package assignment5;

import java.util.Comparator;
import java.util.Iterator;

// This class represents a student.
public class Student implements Iterable<CourseReport> {
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
        if (courseReport == null) {
            return;
        }
        for (int i = 0; i < courseReports.length; i++) {
            if (courseReports[i] == null) {
                courseReports[i] = new CourseReport(courseReport);
                break;
            }
        }
    }

    // Get the total points of the student
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
                // Calculate the weighted average
                sum += courseReports[i].getGrade() * courseReports[i].getPoints();
                totalPoints += courseReports[i].getPoints();
            }
        }
        double weightedAverage = sum / totalPoints;
        // Ensure the weighted average is between 0 and 100
        if (weightedAverage > 100) {
            return 100;
        } else if (weightedAverage < 0) {
            return 0;
        } else {
            return weightedAverage;
        }

    }


    @Override
    // Compare two students
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        return this.name.equals(other.name) && this.id == other.id;
    }


    @Override
    // Return a string representation of the student
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

    // Iterator
    public Iterator<CourseReport> iterator() {
        return new StudentIterator();
    }

    // Private class for the iterator
    private class StudentIterator implements Iterator<CourseReport> {
        private int currentIndex = 0;

        @Override
        // Check if there is a next course report
        public boolean hasNext() {
            return currentIndex < courseReports.length && courseReports[currentIndex] != null;
        }

        @Override
        // Get the next course report
        public CourseReport next() {
            return courseReports[currentIndex++];
        }
    }

    public static class AverageComparator implements Comparator<Student> {
        @Override
        // Compare two students by their average
        public int compare(Student s1, Student s2) {
            return Double.compare(s1.getWeightedAverage(), s2.getWeightedAverage());
        }
    }

    public static class CoursePointsComparator implements Comparator<Student> {
        @Override
        // Compare two students by their total points
        public int compare(Student s1, Student s2) {
            return Integer.compare((int) s1.getTotalPoints(), (int) s2.getTotalPoints());
        }
    }

}
