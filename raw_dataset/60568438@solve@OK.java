public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    eaten = new boolean[n];
    int[] a = new int[k];
    int[] b = new int[k];
    for (int i = 0; i < k; ++i) {
        a[i] = in.nextInt() - 1;
        b[i] = in.nextInt() - 1;
    }
    graph = GraphLight.fromEdgesArray(n, k, a, b, false);
    int happy = 0;
    for (int i = 0; i < n; ++i) {
        if (!eaten[i]) {
            happy += eat(i) - 1;
        }
    }
    out.println(k - happy);
// Queue<Integer> que = new LinkedList<>();
// for (int i = 0; i < k; i++) {
// que.add(i);
// }
// 
// HashSet<Integer> eaten = new HashSet<>();
// int consecutiveNonEaten = 0;
// int sadGuest = 0;
// while (!que.isEmpty()) {
// int top = que.poll();
// if (eaten.isEmpty()) {
// eaten.add(a[top]);
// eaten.add(b[top]);
// continue;
// }
// 
// if (!eaten.contains(a[top]) && !eaten.contains(b[top])) {
// if (consecutiveNonEaten < que.size()) {
// consecutiveNonEaten++;
// que.add(top);
// continue;
// } else {
// eaten.add(a[top]);
// eaten.add(b[top]);
// consecutiveNonEaten = 0;
// continue;
// }
// } else if (eaten.contains(a[top]) && eaten.contains(b[top])) {
// sadGuest++;
// continue;
// } else {
// eaten.add(b[top]);
// eaten.add(a[top]);
// consecutiveNonEaten = 0;
// }
// }
// out.println(sadGuest);
}