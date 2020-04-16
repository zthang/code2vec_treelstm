public void solve(int testNumber, Scanner in, PrintWriter out) {
    int t = in.nextInt();
    for (int i = 0; i < t; i++) {
        int n = in.nextInt();
        in.nextLine();
        boolean[] hasMatch = new boolean[n];
        boolean[] kingdms = new boolean[n];
        Set<Integer> done = new HashSet<>();
        for (int j = 0; j < n; j++) {
            int k = in.nextInt();
            int[] prefered = new int[k];
            for (int l = 0; l < k; l++) {
                int prince = in.nextInt();
                if (kingdms[prince - 1]) {
                    prefered[l] = prince;
                } else {
                    if (!hasMatch[j]) {
                        kingdms[prince - 1] = true;
                        hasMatch[j] = true;
                        done.add(j);
                    } else {
                        prefered[l] = prince;
                    }
                }
            }
        }
        if (done.size() < n) {
            int x = 0;
            int y = 0;
            for (int j = 0; j < n; j++) {
                if (!hasMatch[j]) {
                    x = j + 1;
                    break;
                }
            }
            for (int j = 0; j < n; j++) {
                if (!kingdms[j]) {
                    y = j + 1;
                    break;
                }
            }
            out.println("IMPROVE");
            out.println(x + " " + y);
        } else {
            out.println("OPTIMAL");
        }
    }
}