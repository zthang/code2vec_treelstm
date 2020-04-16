static void solve() throws IOException {
    // initIo(true);
    initIo(false);
    StringBuilder sb = new StringBuilder();
    n = ni();
    arr = new Pair[n];
    for (int i = 0; i < n; ++i) {
        arr[i] = new Pair(ni(), ni());
    }
    Arrays.sort(arr, new MyComparator());
    int edges = 0, lim = 2 * (n - 1);
    init(n);
    int[] which_l = new int[2 * n + 1];
    int[] which_r = new int[2 * n + 1];
    for (int i = 0; i < n; ++i) {
        which_l[arr[i].x] = i;
        which_r[arr[i].y] = i;
    }
    TreeSet<Integer> set = new TreeSet<>();
    // pa("arr", arr);
    for (int i = n - 1; i >= 0; --i) {
        int l = arr[i].x;
        // pl("i : "+arr[i]);
        while (true) {
            Integer g = set.higher(l);
            // pl("l: "+l+" g : "+g);
            if (g == null || g > arr[i].y) {
                break;
            }
            un(which_l[g], i);
            edges++;
            l = g;
        }
        set.add(arr[i].x);
        if (edges > lim) {
            break;
        }
    }
    set = new TreeSet<>();
    Arrays.sort(arr);
    // pa("arr", arr);
    for (int i = 0; i < n; ++i) {
        if (edges > lim) {
            break;
        }
        int l = arr[i].x;
        while (true) {
            Integer g = set.higher(l);
            if (g == null || g > arr[i].y) {
                break;
            }
            un(which_r[g], which_l[arr[i].x]);
            ++edges;
            l = g;
        }
        set.add(arr[i].y);
    }
    int root = gr(0);
    boolean isTree = (edges == lim);
    for (int i = 1; i < n; ++i) {
        if (gr(i) != root) {
            isTree = false;
            break;
        }
    }
    if (isTree) {
        pl("YES");
    } else {
        pl("NO");
    }
    pw.flush();
    pw.close();
}