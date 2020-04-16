public void solve(int testNumber, FastInput in, FastOutput out) {
    int n = in.readInt();
    Number[] nums = new Number[n + 1];
    for (int i = 1; i <= n; i++) {
        nums[i] = new Number();
        nums[i].val = i;
    }
    Triangle[] triangles = new Triangle[n - 2];
    for (int i = 0; i < n - 2; i++) {
        triangles[i] = new Triangle();
        triangles[i].id = i;
        for (int j = 0; j < 3; j++) {
            triangles[i].vertexes[j] = in.readInt();
            nums[triangles[i].vertexes[j]].list.add(triangles[i]);
            nums[triangles[i].vertexes[j]].cnt++;
        }
    }
    TreeSet<Number> set = new TreeSet<>((a, b) -> a.cnt == b.cnt ? a.val - b.val : a.cnt - b.cnt);
    for (int i = 1; i <= n; i++) {
        set.add(nums[i]);
    }
    int order = 0;
    while (!set.isEmpty()) {
        Number number = set.pollFirst();
        for (Triangle t : number.list) {
            if (t.order > 0) {
                continue;
            }
            t.order = ++order;
            for (int i = 0; i < 3; i++) {
                if (t.vertexes[i] == number.val) {
                    SequenceUtils.swap(t.vertexes, i, 1);
                    break;
                }
            }
            for (int i = 0; i < 3; i++) {
                boolean removed = set.remove(nums[t.vertexes[i]]);
                nums[t.vertexes[i]].cnt--;
                if (removed) {
                    set.add(nums[t.vertexes[i]]);
                }
            }
        }
    }
    Arrays.sort(triangles, (a, b) -> a.order - b.order);
    map = new LongObjectHashMap<>(3 * n, false);
    for (Triangle t : triangles) {
        putIfNotExist(map, idOfEdge(t.vertexes[0], t.vertexes[1])).addLast(t);
        putIfNotExist(map, idOfEdge(t.vertexes[0], t.vertexes[2])).addLast(t);
        putIfNotExist(map, idOfEdge(t.vertexes[1], t.vertexes[2])).addLast(t);
    }
    triangles[n - 3].handled = true;
    out.append(triangles[n - 3].vertexes[0]).append(' ');
    dfs(triangles[n - 3].vertexes[0], triangles[n - 3].vertexes[1], out);
    out.append(triangles[n - 3].vertexes[1]).append(' ');
    dfs(triangles[n - 3].vertexes[1], triangles[n - 3].vertexes[2], out);
    out.append(triangles[n - 3].vertexes[2]).append(' ');
    dfs(triangles[n - 3].vertexes[2], triangles[n - 3].vertexes[0], out);
    out.println();
    for (Triangle t : triangles) {
        out.append(t.id + 1).append(' ');
    }
    out.println();
}