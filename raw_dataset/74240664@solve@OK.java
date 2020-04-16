private void solve(Scanner in, PrintWriter out) {
    int N = in.nextInt();
    boolean[] princess = new boolean[N];
    boolean[] married = new boolean[N];
    for (int i = 0; i < N; i++) {
        int K = in.nextInt();
        boolean marry = false;
        for (int j = 0; j < K; j++) {
            int prince = in.nextInt();
            if (!princess[prince - 1] && !marry) {
                princess[prince - 1] = true;
                marry = true;
            }
        }
        married[i] = marry;
    }
    for (int i = 0; i < married.length; i++) {
        if (!married[i]) {
            for (int j = 0; j < princess.length; j++) {
                if (!princess[j]) {
                    out.println("IMPROVE");
                    out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }
    }
    out.println("OPTIMAL");
}