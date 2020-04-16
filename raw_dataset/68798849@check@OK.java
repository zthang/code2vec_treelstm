public static boolean check(ArrayList[] graph, int curr, int[] vis) {
    Stack<Integer> st = new Stack<>();
    long vert = 0;
    long edge = 0;
    vert = 1;
    st.push(curr);
    while (!st.isEmpty()) {
        int temp = st.pop();
        vis[temp] = 1;
        ArrayList<Integer> nbrs = graph[temp];
        edge += nbrs.size();
        for (int i = 0; i < nbrs.size(); i++) {
            int nbr = nbrs.get(i);
            if (vis[nbr] == 0) {
                st.push(nbr);
                vis[nbr] = 1;
                vert++;
            }
        }
    }
    if (edge == (vert * (vert - 1))) {
        return true;
    } else {
        return false;
    }
}