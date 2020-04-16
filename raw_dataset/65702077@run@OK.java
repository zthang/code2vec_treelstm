@Override
public void run() {
    try {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        sc = new FastScanner(in);
        if (multiple) {
            int q = sc.nextInt();
            for (int i = 0; i < q; i++) solve();
        } else
            solve();
    } catch (Throwable uncaught) {
        Main.uncaught = uncaught;
    } finally {
        out.close();
    }
}