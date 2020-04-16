public void solve() throws IOException {
    InputReader in = new InputReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);
    int t = in.nextInt();
    outer: while (t-- > 0) {
        int n = in.nextInt();
        char[] s = in.nextLine().toCharArray();
        Vector<Integer> ans = f(s);
        for (int i = 0; i < ans.size(); i++) pw.print(ans.get(i) + " ");
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '>')
                s[i] = '<';
            else
                s[i] = '>';
        }
        for (int i = 0; i < (n - 1) / 2; i++) {
            char tmp = s[i];
            s[i] = s[n - 2 - i];
            s[n - 2 - i] = tmp;
        }
        pw.println();
        Vector<Integer> ans1 = f(s);
        Collections.reverse(ans1);
        for (int i = 0; i < ans1.size(); i++) pw.print(ans1.get(i) + " ");
        pw.println();
    }
    pw.flush();
    pw.close();
}