private static void solve(int q, FastScanner in, PrintWriter out) {
    for (int qq = 0; qq < q; qq++) {
        int n = in.nextInt();
        String s = in.next();
        int[] min = new int[n], max = new int[n];
        List<int[]> smallerIdx = new ArrayList<>();
        int idx = 0;
        int[] curr = null;
        while (idx < n - 1) {
            if (s.charAt(idx) == '>' && curr != null) {
                smallerIdx.add(curr);
                curr = null;
            } else if (s.charAt(idx) == '<') {
                if (curr == null) {
                    curr = new int[2];
                    curr[0] = idx;
                }
                curr[1]++;
            }
            idx++;
        }
        if (curr != null) {
            smallerIdx.add(curr);
        }
        int v = 1;
        // compute min lis
        for (int i = smallerIdx.size() - 1; i >= 0; i--) {
            int start = smallerIdx.get(i)[0];
            int len = smallerIdx.get(i)[1];
            for (int j = 0; j < len; j++) {
                min[start + j] = v;
                v++;
            }
        }
        v = n;
        for (int i = 0; i < n; i++) {
            if (min[i] == 0) {
                min[i] = v;
                v--;
            }
        }
        // compute max lis
        v = 1;
        for (int i = 0; i < smallerIdx.size(); i++) {
            int start = smallerIdx.get(i)[0];
            int len = smallerIdx.get(i)[1];
            for (int j = 0; j < len; j++) {
                max[start + j] = v;
                v++;
            }
        }
        v = n;
        for (int i = 0; i < n; i++) {
            if (max[i] == 0) {
                max[i] = v;
                v--;
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(min[i] + " ");
        }
        out.println();
        for (int i = 0; i < n; i++) {
            out.print(max[i] + " ");
        }
        out.println();
    }
    out.close();
}