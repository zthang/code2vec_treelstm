void solve() throws IOException {
    int n = ni();
    // int[]A=new int[n];
    int[] B = new int[26];
    int nextset = 1;
    for (int x = 0; x < n; x++) {
        boolean f = false;
        int set = nextset;
        String s = next();
        for (int y = 0; y < s.length(); y++) {
            if (B[(int) (s.charAt(y) - 'a')] > 0) {
                f = true;
                set = B[(int) (s.charAt(y) - 'a')];
                break;
            }
        }
        if (f) {
            for (int y = 0; y < s.length(); y++) {
                int a = (int) (s.charAt(y) - 'a');
                if (B[a] == set)
                    continue;
                if (B[a] == 0)
                    B[a] = set;
                else {
                    for (int z = 0; z < 26; z++) {
                        if (z == a)
                            continue;
                        if (B[z] == B[a])
                            B[z] = set;
                    }
                    B[a] = set;
                }
            }
        } else {
            nextset++;
            for (int y = 0; y < s.length(); y++) {
                B[(int) (s.charAt(y) - 'a')] = set;
            }
        }
    }
    boolean[] C = new boolean[30];
    int ans = 0;
    for (int x = 0; x < 26; x++) {
        if (B[x] == 0)
            continue;
        if (C[B[x]])
            continue;
        C[B[x]] = true;
        ans++;
    }
    System.out.println(ans);
}