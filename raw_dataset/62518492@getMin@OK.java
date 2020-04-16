public static long getMin(int x, int y, int z, int n, int index, long[][] c1) {
    visited = new int[n];
    long ans = 0;
    int c = 0;
    int prev = -1;
    while (c <= n - 3) {
        int s1 = adj[index].size();
        if (s1 == 1) {
            visited[index] = 1;
            int i1 = (int) adj[index].get(0);
            visited[i1] = 1;
            int i2 = (int) adj[i1].get(0);
            int i3 = (int) adj[i1].get(1);
            int fi3 = (visited[i2] == 1) ? i3 : i2;
            ans += (c1[x][index] + c1[y][i1] + c1[z][fi3]);
            // if(n==100000&&x==0&&y==1) {
            // System.out.println(index+ "  "+i1 + " "+fi3 );
            // }
            ans1[index] = x + 1;
            ans1[i1] = y + 1;
            ans1[fi3] = z + 1;
            visited[fi3] = 1;
            prev = fi3;
            if (adj[fi3].size() == 2) {
                index = visited[(int) adj[fi3].get(0)] == 1 ? (int) adj[fi3].get(1) : (int) adj[fi3].get(0);
            }
        } else {
            visited[index] = 1;
            int i1 = (int) adj[index].get(0);
            int i2 = (int) adj[index].get(1);
            int fi2 = (visited[i2] == 1) ? i1 : i2;
            visited[fi2] = 1;
            int i3 = (int) adj[fi2].get(0);
            int i4 = (int) adj[fi2].get(1);
            int fi3 = (visited[i3] == 1) ? i4 : i3;
            visited[fi3] = 1;
            ans += (c1[x][index] + c1[y][fi2] + c1[z][fi3]);
            // if(n==100000&&x==0&&y==1) {
            // System.out.println(index+ "  "+fi2 + " "+fi3 );
            // }
            prev = fi3;
            ans1[index] = x + 1;
            ans1[fi2] = y + 1;
            ans1[fi3] = z + 1;
            if (adj[fi3].size() == 2) {
                index = visited[(int) adj[fi3].get(0)] == 1 ? (int) adj[fi3].get(1) : (int) adj[fi3].get(0);
            }
        }
        c += 3;
    }
    if (c == n - 2) {
        int yy = (int) adj[index].get(0) == prev ? (int) adj[index].get(1) : (int) adj[index].get(0);
        ans += (c1[x][index] + c1[y][yy]);
        ans1[index] = x + 1;
        ans1[yy] = y + 1;
    }
    if (c == n - 1) {
        ans1[index] = x + 1;
        ans += c1[x][index];
    }
    // }
    return ans;
}