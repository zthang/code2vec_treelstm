public static ArrayList<ArrayList<Integer>> children(int[] tree) {
    ArrayList<ArrayList<Integer>> children = new ArrayList<>();
    for (int i = 0; i < tree.length; i++) {
        children.add(new ArrayList<>());
    }
    for (int i = 0; i < tree.length; i++) if (tree[i] > -1)
        children.get(tree[i]).add(i);
    return children;
}