public HashSet<Integer> primetable(int m) {
    HashSet<Integer> pt = new HashSet<Integer>();
    for (int i = 2; i <= m; i++) {
        boolean b = true;
        for (int d : pt) {
            if (i % d == 0) {
                b = false;
                break;
            }
        }
        if (b) {
            pt.add(i);
        }
    }
    return pt;
}