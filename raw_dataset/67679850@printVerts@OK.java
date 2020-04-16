public static void printVerts(int x, int start, int end) {
    if (x == -1)
        return;
    // System.out.println(x);
    if (start == -1) {
        // initial
        ans = new ArrayList<>();
        post = new ArrayList<>();
        int y = e[x].get(0);
        HashSet<Integer> s = new HashSet<>(as[x]);
        s.removeAll(as[y]);
        // HashSet<Integer> sc = findCommon(x, y);
        // ArrayList<Integer> comm = new ArrayList<>(sc);
        Point pxy = ep[x].get(0);
        ans.addAll(s);
        ans.add(pxy.x);
        printVerts(y, pxy.x, pxy.y);
        ans.add(pxy.y);
        for (int i = 0; i < ans.size() - 1; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println(ans.get(ans.size() - 1));
        post.add(x);
        for (int i = 0; i < post.size() - 1; i++) {
            System.out.print((post.get(i) + 1) + " ");
        }
        System.out.println(post.get(post.size() - 1) + 1);
    } else {
        HashSet<Integer> s = new HashSet<>(as[x]);
        s.remove(start);
        s.remove(end);
        int mid = -1;
        for (int i : s) mid = i;
        // System.out.println(mid);
        int mid1 = -1, mid2 = -1;
        // for (int y : e[x]) {
        for (int i = 0; i < e[x].size(); i++) {
            int y = e[x].get(i);
            Point pxy = ep[x].get(i);
            // if (sc.size() == 2 && sc.contains(start) && sc.contains(mid)) {
            if (pxy.x == start && pxy.y == mid || pxy.x == mid && pxy.y == start) {
                mid1 = y;
            } else if (pxy.x == end && pxy.y == mid || pxy.x == mid && pxy.y == end) {
                mid2 = y;
            }
        }
        printVerts(mid1, start, mid);
        ans.add(mid);
        printVerts(mid2, mid, end);
        post.add(x);
    }
}