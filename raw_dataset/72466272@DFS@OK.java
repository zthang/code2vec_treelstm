static void DFS(Node s) {
    Stack<Node> st = new Stack<Node>();
    int a = 0, b = 0;
    st.add(s);
    while (st.size() != 0) {
        s = st.pop();
        a = arr[s.x][s.y][x];
        b = arr[s.x][s.y][y];
        for (int i = 0; i < 4; i++) {
            int xx = d[i][0] + s.x, yy = d[i][1] + s.y;
            if (xx > 0 && xx <= n && yy > 0 && yy <= n && ans[xx][yy] == '0' && arr[xx][yy][x] == a && arr[xx][yy][y] == b) {
                if (i == 0)
                    ans[xx][yy] = 'U';
                else if (i == 1)
                    ans[xx][yy] = 'D';
                else if (i == 2)
                    ans[xx][yy] = 'L';
                else
                    ans[xx][yy] = 'R';
                st.add(new Node(xx, yy));
            }
        }
    }
}