void init(int n, int m) {
    next = new int[1 + m * 2];
    zz = new int[1 + m * 2];
    jj = new int[1 + m * 2];
    ao = new int[n];
    visited = new int[n];
    Arrays.fill(visited, -1);
}