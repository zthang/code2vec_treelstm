void solve() throws IOException {
    int tc = readInt();
    while (tc > 0) {
        int n = readInt();
        int m = readInt();
        List<Item> lsItems = new ArrayList<>();
        for (int i = 1; i <= n; i++) lsItems.add(new Item(i, readInt()));
        if (n == 2 || n > m) {
            out.println("-1");
            tc--;
            continue;
        }
        Collections.sort(lsItems);
        int res = 0;
        List<String> lsRes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res += lsItems.get(i).weight + lsItems.get((i + 1) % n).weight;
            lsRes.add(lsItems.get(i).index + " " + lsItems.get((i + 1) % n).index);
        }
        int diff = m - n;
        while (diff > 0) {
            res += lsItems.get(0).weight + lsItems.get(1).weight;
            lsRes.add(lsItems.get(0).index + " " + lsItems.get(1).index);
            diff--;
        }
        out.println(res);
        for (String er : lsRes) out.println(er);
        tc--;
    }
}