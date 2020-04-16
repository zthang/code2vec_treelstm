public void solve(int time) {
    int n = sc.nextInt();
    TaskD.Node[] nodes = new TaskD.Node[n];
    for (int i = 0; i < n; i++) nodes[i] = new TaskD.Node();
    TaskD.Node root = null;
    for (int i = 0; i < n; i++) {
        int parent = sc.nextInt();
        TaskD.Node node = nodes[i];
        if (parent == 0) {
            root = node;
        } else {
            nodes[parent - 1].children.add(node);
        }
        node.c = sc.nextInt();
    }
    dfsPower(root);
    List<Integer> set = new ArrayList<>(n);
    for (int i = 1; i <= n; i++) set.add(i);
    dfs(root, set);
    writeln("YES");
    for (TaskD.Node node : nodes) {
        write(node.a + " ");
    }
    writeln("");
}