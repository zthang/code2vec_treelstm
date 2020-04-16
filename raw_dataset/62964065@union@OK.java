private static void union(int px, int py) {
    if (px == py) {
        runningtotal -= (ss[px].rank * (ss[px].rank - 1l)) / 2l;
        ss[px].rank++;
        runningtotal += (ss[px].rank * (ss[px].rank - 1l)) / 2l;
        // hs.put(px,ss[px].rank);
        return;
    }
    ss[py].parent = px;
    runningtotal -= (ss[py].rank * (ss[py].rank - 1l)) / 2l;
    runningtotal -= (ss[px].rank * (ss[px].rank - 1l)) / 2l;
    ss[px].rank += ss[py].rank;
    runningtotal += (ss[px].rank * (ss[px].rank - 1l)) / 2l;
// if(hs.containsKey(py))hs.remove(py);
// hs.put(px,ss[px].rank);
}