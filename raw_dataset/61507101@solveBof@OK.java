static void solveBof() {
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
    // first wave
    int i = 0;
    Composite X = ar[i];
    if (X.v == 0) {
        output("-1");
        return;
    }
    int u = X.idx;
    assign(u, 0);
    time++;
    for (int v : friends[u]) {
        forbid[v][0] = true;
        visited[v] = time;
    }
    for (int v = 0; v < n; v++) {
        if (visited[v] < time) {
            rem--;
            assign(v, 0);
        }
    }
    // now second wave
    i++;
    int allocated = 1;
    loop: while (i < n) {
        X = ar[i];
        u = X.idx;
        time++;
        if (target[u] == 0) {
            for (int v : friends[u]) {
                if (target[v] == 0) {
                    output("-1");
                    return;
                }
                visited[v] = time;
                forbid[v][0] = true;
            }
        } else {
            rem--;
            assign(u, 1);
            for (int v : friends[u]) {
                visited[v] = time;
                forbid[v][1] = true;
            }
            for (int v = 0; v < n; v++) {
                if (visited[v] < time) {
                    // so color =1
                    if (target[v] == 0) {
                        output("-1");
                        return;
                    }
                    rem--;
                    assign(v, 1);
                }
            }
            break loop;
        }
    }
// now 3rd wave
}