private boolean coLinear(int[] p, int[] q, int[] r) {
    return 1L * (p[1] - r[1]) * (q[0] - r[0]) == 1L * (q[1] - r[1]) * (p[0] - r[0]);
}