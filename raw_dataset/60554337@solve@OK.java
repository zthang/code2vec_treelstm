public void solve(int testNumber, InputReader in, PrintWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    ArrayList<Integer>[] cow = new ArrayList[n];
    for (int i = 0; i < n; i++) {
        cow[i] = new ArrayList<>();
    }
    TreeSet<Animal> set = new TreeSet<>();
    int[] has = new int[k];
    Arrays.fill(has, 2);
    int[][] fav = new int[k][2];
    for (int i = 0; i < k; i++) {
        int x = in.nextInt() - 1;
        int y = in.nextInt() - 1;
        cow[x].add(i);
        cow[y].add(i);
        fav[i][0] = x;
        fav[i][1] = y;
        set.add(new Animal(2, i));
    }
    boolean[] removed = new boolean[k];
    int sad = 0;
    while (!set.isEmpty()) {
        Animal first = set.pollFirst();
        int idx = first.idx;
        removed[idx] = true;
        int x = fav[idx][0];
        int y = fav[idx][1];
        if (cow[x].isEmpty() && cow[y].isEmpty())
            sad++;
        else {
            for (int inX : cow[x]) {
                if (removed[inX])
                    continue;
                set.remove(new Animal(has[inX], inX));
                has[inX]--;
                set.add(new Animal(has[inX], inX));
            }
            cow[x].clear();
            for (int inY : cow[y]) {
                if (removed[inY])
                    continue;
                set.remove(new Animal(has[inY], inY));
                has[inY]--;
                set.add(new Animal(has[inY], inY));
            }
            cow[y].clear();
        }
    }
    out.println(sad);
}