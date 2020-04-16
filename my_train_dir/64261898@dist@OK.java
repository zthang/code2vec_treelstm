static long dist(int o1, int o2) {
    return (long) (k[o1] + k[o2]) * (Math.abs(x[o1] - x[o2]) + Math.abs(y[o1] - y[o2]));
}