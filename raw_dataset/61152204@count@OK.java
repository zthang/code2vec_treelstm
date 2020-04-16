public static int count(int[] numbering, Point[] edges) {
    HashMap used = new HashMap(42);
    int count = 0;
    for (Point p : edges) {
        int d1 = numbering[p.x];
        int d2 = numbering[p.y];
        String domino = d1 + " " + d2;
        if (!used.containsKey(domino)) {
            used.put(domino, domino);
            used.put(d2 + " " + d1, d2 + " " + d1);
            count++;
        }
    }
    return count;
}