void solve(InputReader in, PrintWriter out) {
    int t = in.nextInt();
    while (t-- > 0) {
        int n = in.nextInt();
        String s = in.next();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = n - i;
        }
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            while (i < s.length() && s.charAt(i) == '<') {
                i++;
            }
            reverse(a, l, i);
        }
        for (int i = 0; i < n; i++) {
            out.print(a[i] + " ");
        }
        out.println();
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            while (i < s.length() && s.charAt(i) == '>') {
                i++;
            }
            reverse(a, l, i);
        }
        for (int i = 0; i < n; i++) {
            out.print(a[i] + " ");
        }
        out.println();
    }
}