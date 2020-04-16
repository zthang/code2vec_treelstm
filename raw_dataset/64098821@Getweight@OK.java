public static long Getweight(int i, int j) {
    return (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j])) * (k[i] + k[j]);
}