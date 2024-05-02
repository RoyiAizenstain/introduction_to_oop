package assignment1;

public class ChessThreat {
    public static boolean CheckThreats(int type, int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) return false;
        if (type == 1) {
            return (Math.abs(x1 - x2) == Math.abs(y1 - y2));
        } else if (type == 2) {
            return (x1 == x2 || y1 == y2);
        } else if (type == 3) {
            return (Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1) || (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2);
        } else {
            return false;
        }
    }
}