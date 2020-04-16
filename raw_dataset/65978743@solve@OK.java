public void solve(int testNumber, ScanReader in, PrintWriter out) {
    int n = in.scanInt();
    ArrayList<Integer>[] arrayList = new ArrayList[26];
    arr = new int[n + 1];
    size = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        arr[i] = i;
        size[i] = 1;
    }
    for (int i = 0; i < 26; i++) arrayList[i] = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        char[] arr = in.scanString().toCharArray();
        HashSet<Character> hashSet = new HashSet<>();
        for (char c : arr) {
            if (hashSet.contains(c))
                continue;
            hashSet.add(c);
            arrayList[c - 'a'].add(i + 1);
        }
    }
    for (int i = 0; i < 26; i++) {
        for (int j = 1; j < arrayList[i].size(); j++) {
            int a = arrayList[i].get(j);
            int b = arrayList[i].get(j - 1);
            if (root(a) != root(b)) {
                w_union(a, b);
            }
        }
    }
    int ans = 0;
    for (int i = 1; i <= n; i++) {
        if (size[i] != 0)
            ans++;
    }
    out.println(ans);
}