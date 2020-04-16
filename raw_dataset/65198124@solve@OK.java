void solve(InputReader in, PrintWriter w) {
    int n = in.nextInt();
    int m = in.nextInt();
    arr = new int[n + 1];
    size = new int[n + 1];
    initialize(n);
    for (int i = 0; i < m; i++) {
        int u = in.nextInt(), v = in.nextInt();
        union(u, v);
    }
    // for(int i = 1; i <= n; i++) {
    // arr[i] = root(i);
    // }
    // System.out.println(Arrays.toString(arr));
    int res = 0;
    Stack<Integer> stack = new Stack<>();
    Set<Integer> colorSet = new HashSet<>();
    for (int i = 1; i <= n; i++) {
        int color = root(arr[i]);
        if (stack.isEmpty()) {
            stack.push(color);
            colorSet.add(color);
        } else {
            if (colorSet.contains(color)) {
                while (root(stack.peek()) != color) {
                    int color1 = root(stack.pop());
                    union(color, color1);
                    color = root(color);
                    res++;
                }
            } else {
                stack.push(color);
                colorSet.add(color);
            }
        }
    // System.out.println(i + " " + stack);
    }
    w.println(res);
}