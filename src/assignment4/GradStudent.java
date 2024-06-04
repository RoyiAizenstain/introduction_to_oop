package assignment4;

public class GradStudent extends Student {
    // Default constructor
    public GradStudent() {
        super();
        this.bonus = 0;
    }

    // Constructor
    public GradStudent(String name, int id, int numOfCourses, double bonus) {
        super(name, id, numOfCourses);
        this.bonus = bonus;
    }

    // Copy constructor
    public GradStudent(GradStudent other) {
        super(other);
        if(other != null) {
            this.bonus = other.bonus;
        }
        else{
            this.bonus = 0;
        }
    }

    // Getters and setters
    public double getBonus() {
        return this.bonus;
    }

    // Set the bonus
    public void setBonus(double bonus) {
        if (bonus >= 0) {
            this.bonus = bonus;
        }
    }

    // Calculate the weighted average
    @Override
    public double getWeightedAverage() {
        double average = super.getWeightedAverage();
        double points = super.getTotalPoints();
        // If the student has 10 or more points, add the bonus
        if (points >= 10)
            average = average + this.bonus;
        else
            average = average - this.bonus;
        if (average > 100) {
            return 100;
        } else {
            return average;
        }
    }

    private double bonus;
}