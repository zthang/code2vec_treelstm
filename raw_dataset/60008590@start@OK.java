public void start() throws IOException {
    fs = new FScanner(new InputStreamReader(System.in));
    // reader = new FScanner(new FileReader("input"));
    // pw = new PrintWriter("input.txt");
    pw = new PrintWriter(System.out);
    int n = fs.nextInt();
    Pair[] arr = new Pair[n];
    for (int i = 0; i < n; i++) {
        arr[i] = new Pair(i * 2, fs.nextInt());
    }
    Arrays.sort(arr, new Comparator<Pair>() {

        @Override
        public int compare(Pair pair, Pair t1) {
            return -Integer.compare(pair.y, t1.y);
        }
    });
    HashMap<Integer, Pair> map = new HashMap<>();
    ArrayList<Integer>[] placevids = new ArrayList[n * 2];
    for (int i = 0; i < n * 2; i++) {
        placevids[i] = new ArrayList<>();
    }
    int pos = 0;
    boolean even = true;
    for (int i = 0; i < n; i++) {
        if (even) {
            map.put(pos, arr[i]);
        } else {
            pos++;
            map.put(n - pos, arr[i]);
        }
        even ^= true;
    }
    for (int i = 0; i < n - 1; i++) {
        placevids[map.get(i).x].add(map.get(i + 1).x);
    }
    boolean[] used = new boolean[n];
    even = true;
    for (int i = 0; ; ) {
        int gi = even ? i : n - i - 1;
        if (used[gi])
            break;
        Pair cur = map.get(gi);
        if (cur.y == 1) {
            placevids[cur.x].add(cur.x + 1);
        } else {
            Pair rari = null;
            int qe = 0;
            boolean minus = false;
            if (map.containsKey(gi - cur.y + 1)) {
                rari = map.get(gi - cur.y + 1);
                minus = true;
                qe = gi - cur.y + 1;
            } else {
                rari = map.get(gi + cur.y - 1);
                minus = false;
                qe = gi + cur.y - 1;
            }
            placevids[rari.x].add(cur.x + 1);
            if (minus && !map.containsKey(qe - 1)) {
                map.put(qe - 1, new Pair(cur.x + 1, -1));
            } else if (!minus && !map.containsKey(qe + 1)) {
                map.put(qe + 1, new Pair(cur.x + 1, -1));
            }
        }
        used[gi] = true;
        if (!even)
            i++;
        even ^= true;
    }
    for (int i = 0; i < placevids.length; i++) {
        for (int x : placevids[i]) {
            pw.println(i + 1 + " " + (x + 1));
        }
    }
    pw.close();
}