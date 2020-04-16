void solve() {
    DisJointSet dj = new DisJointSet(26);
    boolean[] mark = new boolean[26];
    for (int i = scn.nextInt(); i > 0; i--) {
        char[] s = scn.next().toCharArray();
        for (int j = 1; j < s.length; j++) {
            dj.union(s[j] - 'a', s[j - 1] - 'a');
        }
        for (char c : s) {
            mark[c - 'a'] = true;
        }
    }
    int sub = 0;
    for (boolean b : mark) {
        if (!b) {
            sub++;
        }
    }
    out.println(dj.size - sub);
}