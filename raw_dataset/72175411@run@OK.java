@Override
public void run() {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    FastInput in = new FastInput(inputStream);
    FastOutput out = new FastOutput(outputStream);
    BNavigationSystem solver = new BNavigationSystem();
    solver.solve(1, in, out);
    out.close();
}