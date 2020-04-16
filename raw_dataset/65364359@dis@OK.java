public static double dis(int x, int y, int[] x1, int[] y1, int[] x2, int[] y2, int[] x3, int[] y3) {
    double[] d1 = new double[x1.length];
    double[] d2 = new double[x2.length];
    Arrays.fill(d2, Long.MAX_VALUE);
    for (int i = 0; i < x1.length; i++) {
        d1[i] = Math.sqrt(Math.pow(x1[i] - x, 2) + Math.pow(y1[i] - y, 2));
    }
    for (int i = 0; i < x2.length; i++) {
        for (int j = 0; j < x3.length; j++) {
            d2[i] = Math.min(Math.sqrt(Math.pow(x2[i] - x3[j], 2) + Math.pow(y2[i] - y3[j], 2)), d2[i]);
        }
    }
    double min = Long.MAX_VALUE;
    for (int i = 0; i < x1.length; i++) {
        for (int j = 0; j < x2.length; j++) {
            min = Math.min(d1[i] + d2[j] + Math.sqrt(Math.pow(x1[i] - x2[j], 2) + Math.pow(y1[i] - y2[j], 2)), min);
        }
    }
    return min;
}