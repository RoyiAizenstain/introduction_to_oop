package assignment1;

public class ChessThreat {
    /*
     * Check if a piece of type 1/2/3 at position (x1, y1) threatens a piece at position (x2, y2)
     * @param type of the piece
     * @param x1 x-coordinate of the threatening piece
     * @param y1 y-coordinate of the threatening piece
     * @param x2 x-coordinate of the threatened piece
     * @param y2 y-coordinate of the threatened piece
     * @return true if the piece threatens the other piece, false otherwise
     */
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