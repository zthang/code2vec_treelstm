@Override
public void run() {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    FastInput in = new FastInput(inputStream);
    FastOutput out = new FastOutput(outputStream);
    FNewYearAndSocialNetwork solver = new FNewYearAndSocialNetwork();
    solver.solve(1, in, out);
    out.close();
}