@Override
public void run() {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    FastInput in = new FastInput(inputStream);
    FastOutput out = new FastOutput(outputStream);
    DNashMatrix solver = new DNashMatrix();
    solver.solve(1, in, out);
    out.close();
}