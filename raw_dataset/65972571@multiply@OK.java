public long[] multiply(long[] a, long[] b) {
    int resultSize = Integer.highestOneBit(Math.max(a.length, b.length) - 1) << 2;
    resultSize = Math.max(resultSize, 1);
    double[] aReal = new double[resultSize];
    double[] aImaginary = new double[resultSize];
    double[] bReal = new double[resultSize];
    double[] bImaginary = new double[resultSize];
    for (int i = 0; i < a.length; i++) aReal[i] = a[i];
    for (int i = 0; i < b.length; i++) bReal[i] = b[i];
    fft(aReal, aImaginary, false);
    fft(bReal, bImaginary, false);
    for (int i = 0; i < resultSize; i++) {
        double real = aReal[i] * bReal[i] - aImaginary[i] * bImaginary[i];
        aImaginary[i] = aImaginary[i] * bReal[i] + bImaginary[i] * aReal[i];
        aReal[i] = real;
    }
    fft(aReal, aImaginary, true);
    long[] result = new long[resultSize];
    for (int i = 0; i < resultSize; i++) result[i] = Math.round(aReal[i]);
    return result;
}