private static void execute(ContestReader reader, PrintWriter out) {
    int n = reader.nextInt();
    int[][] xys = reader.nextIntMatrix(n, 2);
    int[] cs = reader.nextIntArray(n);
    int[] ks = reader.nextIntArray(n);
    for (String line : new Solver(n, xys, cs, ks).solve()) {
        out.println(line);
    }
}