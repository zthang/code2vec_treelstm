double[] readDoubleArray(int n) throws IOException {
    double[] answer = new double[n];
    for (int i = 0; i < n; ++i) {
        answer[i] = nextDouble();
    }
    return answer;
}