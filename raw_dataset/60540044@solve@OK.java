public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.readInt();
    int k = in.readInt();
    int[] x = new int[k];
    int[] y = new int[k];
    in.readIntArrays(x, y);
    MiscUtils.decreaseByOne(x, y);
    IndependentSetSystem setSystem = new ListIndependentSetSystem(n);
    int answer = 0;
    for (int i = 0; i < k; i++) {
        if (!setSystem.join(x[i], y[i])) {
            answer++;
        }
    }
    out.printLine(answer);
}