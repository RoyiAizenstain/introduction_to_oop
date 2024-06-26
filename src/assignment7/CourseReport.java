package assignment7;

import java.io.*;


// This class represents a course report.
public class CourseReport implements Comparable<CourseReport>, Serializable {
    // Default constructor
    public CourseReport() {
        this.name = null;
        this.points = 0;
        this.grade = 0;
    }

    // Save the course report to a text file
    public void saveToTextFile(File file) {
        // Write the course report to the file
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(this.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Load the course report from a text file
    public CourseReport(File file) {
        try {
            // Read the course report from the file
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            String[] parts = line.split(", ");
            this.name = parts[0].substring(1);
            if (this.name.equals("null"))
                this.name = null;
            this.points = Integer.parseInt(parts[1]);
            this.grade = Double.parseDouble(parts[2].substring(0, parts[2].length() - 1));


            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Constructor
    public CourseReport(String name, int points, double grade) {
        this.name = name;
        this.points = points;
        this.grade = grade;
    }

    // Copy constructor
    public CourseReport(CourseReport other) {
        if (other == null) {
            this.name = null;
            this.points = 0;
            this.grade = 0;
            return;
        }
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

    // Get the name of the course
    public String getName() {
        // Return the name of the course
        return this.name;
    }

    // Set the name of the course
    public void setName(String name) {
        // Set the name of the course
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    // Get the points of the course
    public int getPoints() {
        // Return the points of the course
        return this.points;
    }

    public void setPoints(int points) {
        // Set the points of the course
        if (points > 0)
            this.points = points;
    }


    @Override
    // Compare two course reports
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        CourseReport other = (CourseReport) obj;
        return this.name.equals(other.name) && this.points == other.points && this.grade == other.grade;
    }


    @Override
    // Return a string representation of the course report
    public String toString() {
        return ("[" + this.name + ", " + this.points + ", " + this.grade + "]");
    }

    @Override
    // Compare two course reports
    public int compareTo(CourseReport other) {
        // Compare by grade
        int gradeComparison = Double.compare(this.grade, other.grade);
        if (gradeComparison != 0) {
            return gradeComparison;
        }

        // Compare by points
        int pointsComparison = Integer.compare(this.points, other.points);
        if (pointsComparison != 0) {
            return pointsComparison;
        }

        // Compare by name
        return this.name.compareTo(other.name);
    }


    // Instance fields
    private String name;
    private int points;
    private double grade;
}
