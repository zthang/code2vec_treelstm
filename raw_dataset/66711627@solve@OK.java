public void solve(int testNumber, FastReader scan, PrintWriter out) {
    int n = scan.nextInt();
    int[] a = new int[n];
    int[] distEven = new int[n], distOdd = new int[n];
    boolean[] visitedEven = new boolean[n], visitedOdd = new boolean[n];
    ArrayList<Integer>[] left = new ArrayList[n];
    ArrayList<Integer>[] right = new ArrayList[n];
    ArrayDeque<Integer> even = new ArrayDeque<>(), odd = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
        left[i] = new ArrayList<>();
        right[i] = new ArrayList<>();
        if (a[i] % 2 == 0) {
            even.add(i);
            visitedEven[i] = true;
        } else {
            odd.add(i);
            visitedOdd[i] = true;
        }
    }
    for (int i = 0; i < n; i++) {
        if (i + a[i] < n)
            left[i + a[i]].add(a[i]);
        if (i - a[i] >= 0)
            right[i - a[i]].add(a[i]);
    }
    while (!even.isEmpty()) {
        int p = even.pollFirst();
        for (int x : left[p]) {
            if (!visitedEven[p - x]) {
                visitedEven[p - x] = true;
                distEven[p - x] = distEven[p] + 1;
                even.addLast(p - x);
            }
        }
        for (int x : right[p]) {
            if (!visitedEven[p + x]) {
                visitedEven[p + x] = true;
                distEven[p + x] = distEven[p] + 1;
                even.addLast(p + x);
            }
        }
    }
    while (!odd.isEmpty()) {
        int p = odd.pollFirst();
        for (int x : left[p]) {
            if (!visitedOdd[p - x]) {
                visitedOdd[p - x] = true;
                distOdd[p - x] = distOdd[p] + 1;
                odd.addLast(p - x);
            }
        }
        for (int x : right[p]) {
            if (!visitedOdd[p + x]) {
                visitedOdd[p + x] = true;
                distOdd[p + x] = distOdd[p] + 1;
                odd.addLast(p + x);
            }
        }
    }
    for (int i = 0; i < n; i++) {
        int curr = a[i] % 2 == 0 ? distOdd[i] : distEven[i];
        if (curr == 0)
            curr = -1;
        out.print(curr);
        out.print(" ");
    }
}