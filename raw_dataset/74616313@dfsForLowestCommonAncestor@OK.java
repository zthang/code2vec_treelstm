static void dfsForLowestCommonAncestor(int root, int parent) {
    // w.print(root+" ");
    visited[root] = true;
    intime[root] = ++time;
    up[root][0] = parent;
    for (int i = 1; i < 21; i++) {
        up[root][i] = up[up[root][i - 1]][i - 1];
    }
    // position[time]=root;
    // nodes[index]=root;
    // value[index]=values[root];
    // indices[root]=index;
    // index++;
    Iterator itr = arr[root].iterator();
    while (itr.hasNext()) {
        int a = (int) itr.next();
        if (!visited[a]) {
            dfsForLowestCommonAncestor(a, root);
        // child[root]+=child[a];
        // w.print(root+" ");
        }
    }
    // child[root]++;
    outime[root] = ++time;
// position[time]=root;
// w.print(root+" ");
}