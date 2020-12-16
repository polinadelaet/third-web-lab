package service;

public final class CheckHitPoint {

    private static boolean isHitToFirstQuarter(double x, double y, double r) {
        return (x <= r) && (x >= 0) && (0 <= y) && (y <= r * 0.5 );
    }

    private static boolean isHitToSecondQuarter(double x, double y, double r) {
        return (x <= 0) && (y >= 0) && (y < x + r);
    }

    private static boolean isHitToThirdQuarter(double x, double y, double r) {
        return false;
    }

    private static boolean isHitToFourthQuarter(double x, double y, double r) {
        return (0 <= x) && (x * x <= r * r - y * y) && (y <= 0);
    }

    public static boolean checkHit(double x, double y, double r) {
        return isHitToFirstQuarter(x, y, r) || isHitToSecondQuarter(x, y, r) || isHitToThirdQuarter(x, y, r) || isHitToFourthQuarter(x, y, r);
    }
}
