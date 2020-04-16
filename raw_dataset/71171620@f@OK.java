// static ArrayList[] a = new ArrayList[200001];
static Vector<Integer> f(char[] s) {
    int n = s.length + 1;
    int end = -1;
    boolean[] chk = new boolean[n + 1];
    for (int i = 1; i < n - 1; i++) {
        if (s[i] != s[i - 1]) {
            if (s[i] == '<') {
                chk[i - 1] = true;
            }
        }
    }
    int last = -1;
    boolean got = false;
    int mid = -1;
    int ans = n + 1;
    Vector<Integer> v = new Vector<>();
    for (int i = 0; i < n - 1; i++) {
        if (s[i] == '>' && !got) {
            got = true;
            mid = i;
        }
        if (chk[i]) {
            int len = i - last;
            int can = ans - len;
            for (int j = 0; j < mid - last - 1; j++) {
                v.add((int) (can + j));
            }
            for (int j = mid - last - 1; j < len; j++) {
                ans--;
                v.add(ans);
            }
            ans = can;
            last = i;
            mid = -1;
            got = false;
        }
    }
    int len = n - 1 - last;
    int can = ans - len;
    if (mid == -1) {
        for (int i = 0; i < len; i++) {
            v.add(can + i);
        }
    }
    for (int j = 0; j < mid - last - 1 && mid != -1; j++) {
        v.add((int) (can + j));
    }
    for (int j = mid - last - 1; j < len && mid != -1; j++) {
        ans--;
        v.add(ans);
    }
    return v;
}