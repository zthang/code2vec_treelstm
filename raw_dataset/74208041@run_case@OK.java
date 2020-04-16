private void run_case() {
    int n = reader.ni();
    // TreeMap<Integer, Integer> used = new TreeMap<>();
    // int max_idx_prince = 0;
    // for (int i=1; i<=n; i++) used.put(i, -1);
    int[] arr_m = new int[n];
    int[] arr_p = new int[n];
    // int fail_married_idx = -1;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
        int m = reader.ni();
        boolean done = false;
        for (int j = 0; j < m; j++) {
            int t = reader.ni();
            if (!done && arr_p[t - 1] == 0) {
                arr_m[i] = 1;
                arr_p[t - 1] = 1;
                cnt++;
                done = true;
            }
        }
    }
    if (cnt == n) {
        System.out.println("OPTIMAL");
    } else {
        System.out.println("IMPROVE");
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (arr_m[i] == 0) {
                a = i + 1;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr_p[i] == 0) {
                b = i + 1;
                break;
            }
        }
        System.out.println(a + " " + b);
    }
    return;
}