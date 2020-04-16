public void run() {
    try {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    } catch (IOException e) {
        e.printStackTrace();
        System.exit(1);
    }
}