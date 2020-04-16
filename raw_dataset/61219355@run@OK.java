private void run() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] line = reader.readLine().split("\\s");
    int v = Integer.parseInt(line[0]), e = Integer.parseInt(line[1]);
    int[][] m = new int[8][8];
    if (e == 0) {
        System.out.println(0);
        return;
    }
    int[] vertexes = new int[8];
    List<int[]> pairs = new ArrayList<>();
    for (int i = 0; i < e; i++) {
        line = reader.readLine().split("\\s");
        int a = Integer.parseInt(line[0]), b = Integer.parseInt(line[1]);
        vertexes[a]++;
        vertexes[b]++;
        pairs.add(new int[] { a, b });
        m[a][b] = 1;
        m[b][a] = 1;
    }
    boolean nil = false;
    for (int i = 1; i < vertexes.length; i++) {
        if (vertexes[i] == 0)
            nil = true;
    }
    int ans = 0;
    int extra = -1;
    if (!nil) {
        int min = Integer.MAX_VALUE, add = 0;
        for (int i = 1; i < 7; i++) {
            for (int j = i + 1; j <= 7; j++) {
                int soc = 0, tAdd = 0;
                for (int k = 1; k <= 7; k++) {
                    if (k == i || k == j)
                        continue;
                    if (m[i][k] == 1 && m[j][k] == 1)
                        soc++;
                    else if (m[i][k] == 1 && m[j][k] == 0)
                        tAdd++;
                }
                if (soc < min) {
                    if (m[i][j] == 1)
                        tAdd++;
                    add = tAdd;
                    min = soc;
                    extra = i;
                }
            }
        }
        ans += add;
    }
    for (int[] pair : pairs) {
        if (pair[0] != extra && pair[1] != extra)
            ans++;
    }
    System.out.println(ans);
}