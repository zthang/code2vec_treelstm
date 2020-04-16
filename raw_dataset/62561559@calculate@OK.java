static long calculate(ArrayList[] sets, int x, int y, int z, int[][] c, int[] paint) {
    long val = 0;
    for (int i = 0; i < sets[0].size(); i++) {
        val += c[(int) sets[0].get(i)][x];
        paint[(int) sets[0].get(i)] = x;
    }
    for (int i = 0; i < sets[1].size(); i++) {
        val += c[(int) sets[1].get(i)][y];
        paint[(int) sets[1].get(i)] = y;
    }
    for (int i = 0; i < sets[2].size(); i++) {
        val += c[(int) sets[2].get(i)][z];
        paint[(int) sets[2].get(i)] = z;
    }
    return val;
}