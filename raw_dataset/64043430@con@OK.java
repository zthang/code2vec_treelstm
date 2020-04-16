private long con(Point p1, Point p2) {
    long dist = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    return (p1.k + p2.k) * dist;
}