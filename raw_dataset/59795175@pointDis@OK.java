public double pointDis(pair p1) {
    return Math.sqrt(((Integer) y - (Integer) p1.y) * ((Integer) y - (Integer) p1.y) + ((Integer) x - (Integer) p1.x) * ((Integer) x - (Integer) p1.x));
}