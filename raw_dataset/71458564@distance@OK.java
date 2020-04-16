private static double distance(Point p1, Point p2) {
    long divx = p2.x - p1.x;
    long divy = p2.y - p1.y;
    divx = divx * divx;
    divy = divy * divy;
    return Math.sqrt(divx + divy);
}