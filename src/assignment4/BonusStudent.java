package assignment4;

public class BonusStudent extends Student {
    // Default constructor
    public BonusStudent() {
        super();
        this.mult = 1;
    }
    // Constructor
    public BonusStudent(String name, int id, int numOfCourses, double mult) {
        super(name, id, numOfCourses);
        this.mult = mult;
    }
    // Copy constructor
    public BonusStudent(BonusStudent other) {
        super(other);
        this.mult = other.mult;
    }
    // Getters and setters
    public double getMult() {
        return this.mult;
    }
    // Set the multiplier
    public void setMult(double mult) {
        if (mult > 0)
            this.mult = mult;
    }
    // Calculate the weighted average
    @Override
    public double getWeightedAverage() {
        double average = super.getWeightedAverage();
        double points = super.getTotalPoints();
        average =average + Math.floor(points / 10) * mult;
        if (average > 100) {
            return 100;
        } else {
            return average;
        }

    }

    private double mult;
}
