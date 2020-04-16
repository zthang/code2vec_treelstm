public void go() throws IOException {
    ntok();
    int n = ipar();
    ntok();
    int[] arr = iapar(n);
    ArrayList<int[]> pairs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        pairs.add(new int[] { i, arr[i] });
    }
    Collections.sort(pairs, (a, b) -> {
        if (a[1] == b[1]) {
            return Integer.compare(a[0], b[0]);
        }
        return -Integer.compare(a[1], b[1]);
    });
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        list.add(new ArrayList<>());
        list.get(i).add(pairs.get(i)[0] * 2);
    }
    for (int i = 0; i < n; i++) {
        int[] curr = pairs.get(i);
        if (i + curr[1] >= list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(i + curr[1]).add(curr[0] * 2 + 1);
    }
    for (int i = 0; i < list.size() - 1; i++) {
        for (int e = 0; e < list.get(i + 1).size(); e++) {
            out.print(list.get(i).get(0) + 1);
            out.print(" ");
            out.println(list.get(i + 1).get(e) + 1);
        }
    }
    out.flush();
    in.close();
}