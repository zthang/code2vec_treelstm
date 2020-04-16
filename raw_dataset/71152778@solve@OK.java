public static void solve(InputReader sc, PrintWriter pw) {
    int i, j = 0;
    // int t=1;
    int t = sc.nextInt();
    u: while (t-- > 0) {
        int n = sc.nextInt();
        String s = sc.next();
        char[] ch = s.toCharArray();
        int[] lo = new int[n];
        int[] sho = new int[n];
        int start = 1, end = n;
        for (i = 0; i < n - 1; i++) {
            if (ch[i] == '<')
                lo[i] = start++;
            else
                lo[i] = end--;
        }
        lo[i] = start;
        start = 1;
        end = n;
        for (i = 0; i < n - 1; i++) {
            if (ch[i] == '>')
                sho[i] = end--;
        }
        int h = n - 1, f = 0;
        for (i = n - 1; i >= 0; i--) {
            if (f == 0 && sho[i] > 0) {
                h = i - 1;
                continue;
            }
            f = 1;
            if (sho[i] > 0) {
                for (j = i + 1; j <= h; j++) {
                    sho[j] = start++;
                }
                h = i - 1;
                f = 0;
            }
            if (i == 0) {
                for (j = 0; j <= h; j++) {
                    sho[j] = start++;
                }
                h = i - 1;
                f = 0;
            }
        }
        for (i = 0; i < n; i++) {
            pw.print(sho[i] + " ");
        }
        pw.println();
        for (i = 0; i < n; i++) {
            pw.print(lo[i] + " ");
        }
        pw.println();
    }
}