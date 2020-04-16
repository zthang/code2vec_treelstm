private void dfs(TaskD.Node root, List<Integer> set) {
    if (root.power <= root.c)
        answer("NO");
    root.a = set.remove(root.c);
    for (TaskD.Node child : root.children) {
        dfs(child, set.subList(0, child.power));
    }
}