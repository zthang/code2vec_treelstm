public void solve(int testNumber, FastReader s, PrintWriter out) {
    int n = s.nextInt();
    int[] a = s.nextIntArray(n);
    int[] b = s.nextIntArray(n);
    int[] c = s.nextIntArray(n);
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    for (int i = 0; i < n - 1; i++) {
        int src = s.nextInt();
        int dest = s.nextInt();
        ArrayList<Integer> neighb = map.getOrDefault(src, new ArrayList<>());
        neighb.add(dest);
        map.put(src, neighb);
        neighb = map.getOrDefault(dest, new ArrayList<>());
        neighb.add(src);
        map.put(dest, neighb);
    }
    Iterator<Integer> iter = map.keySet().iterator();
    boolean ansPossible = true;
    int src = -1;
    while (iter.hasNext()) {
        int curr = iter.next();
        if (map.get(curr).size() > 2) {
            ansPossible = false;
            break;
        } else if (map.get(curr).size() == 1) {
            src = curr;
        }
    }
    if (!ansPossible) {
        out.println(-1);
        return;
    }
    long min = Long.MAX_VALUE;
    int[] ans = null;
    for (int i = 1; i <= 3; i++) {
        for (int j = 1; j <= 3; j++) {
            if (i == j) {
                continue;
            } else {
                int[] arrrr = new int[n];
                long a1 = func(src, i, j, map, a, b, c, new HashSet<>(), arrrr);
                if (a1 < min) {
                    min = a1;
                    ans = arrrr;
                }
            }
        }
    }
    out.println(min);
    out.println(DPaintTheTree.arrays.printArr(ans));
}