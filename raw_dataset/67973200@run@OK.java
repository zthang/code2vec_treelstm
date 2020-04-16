public void run() {
    System.err.println("go!");
    FS in = new FS();
    PrintWriter out = new PrintWriter(System.out);
    solve(in, out);
    out.close();
}