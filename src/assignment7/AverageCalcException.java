package assignment7;

// This class represents an exception that is thrown when the average calculation fails.
public class AverageCalcException extends RuntimeException {
    // The name of the student
    private String studentName;

    // Constructor
    public AverageCalcException(String studentName) {
        this.studentName = studentName;

    }

    // Get the name of the student
    public String getStudentName() {
        return studentName;
    }
}