static void solve() {
    int n = friends.length;
    Composite[] ar = new Composite[n];
    for (int i = 0; i < n; i++) {
        ar[i] = new Composite(friends[i].size(), i);
    }
    Arrays.sort(ar);
    target = new int[n];
    visited = new int[n];
    forbid = new boolean[n][3];
    int time = 1;
    Arrays.fill(target, -1);
    int rem = n;
    int color = 0;
    int i = 0;
    while (i < n && color < 3) {
        Composite X = ar[i];
        if (X.v == 0) {
            log("error 1");
            output("-1");
            return;
        }
        int u = X.idx;
        if (target[u] == -1) {
            // log("assiging :"+color+" to :"+u);
            assign(u, color);
            // log(u+" "+target[u]);
            rem--;
            time++;
            for (int v : friends[u]) {
                visited[v] = time;
            }
            for (int v = 0; v < n; v++) {
                if (visited[v] < time) {
                    if (target[v] != -1 && target[v] != color) {
                        // log("error 2:"+v+" "+target[v]);
                        // log("found "+target[v]+" instead of :"+color);
                        output("-1");
                        return;
                    }
                    assign(v, color);
                }
            }
            color++;
        }
        i++;
    }
    if (color < 3) {
        output("-1");
        return;
    }
    for (int u = 0; u < n; u++) {
        if (target[u] == -1) {
            output("-1");
            return;
        }
    }
    for (int u = 0; u < n; u++) for (int v : friends[u]) {
        if (target[u] == target[v]) {
            output("-1");
            return;
        }
    }
    for (int u = 0; u < n; u++) {
        System.out.print((target[u] + 1) + " ");
    }
    System.out.print("");
}