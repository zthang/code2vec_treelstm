static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    int n = ni();
    Pair[] arr = new Pair[n];
    for (int i = 1; i <= n; ++i) {
        arr[i - 1] = new Pair(ni(), 2 * i - 1);
    }
    Arrays.sort(arr);
    ArrayList<Pair> list = new ArrayList<>();
    // pl("Initial list : ");
    for (int i = n - 1; i >= 0; --i) {
        list.add(arr[i]);
    // p(arr[i].y);
    }
    // pl();
    ArrayList<Pair> ans = new ArrayList<>();
    for (int i = 1; i < list.size(); ++i) {
        ans.add(new Pair(arr[i].y, arr[i - 1].y));
    }
    int till = n;
    for (int i = 0; i < n; ++i) {
        Pair lol = list.get(i);
        if (lol.x == till - i) {
            ans.add(new Pair(list.get(till - 1).y, lol.y + 1));
            // pl("Added edge : " + list.get(till-1).y + "," + (lol.y+1));
            list.add(new Pair(-1, lol.y + 1));
            till++;
        } else {
            ans.add(new Pair(list.get(i + (lol.x - 1)).y, lol.y + 1));
        // pl("Added edge : " + list.get(i+(lol.x - 1)).y + "," + (lol.y+1));
        }
    }
    for (Pair p : ans) {
        sb.append(p.x);
        sb.append(" ");
        sb.append(p.y);
        sb.append("\n");
    }
    // pl("Ans edges : ");
    psb(sb);
    pw.flush();
    pw.close();
}