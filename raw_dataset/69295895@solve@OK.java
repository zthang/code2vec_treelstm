// public class Main
// class code
// public class Solution
static void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    ArrayList<Triplet> list = new ArrayList<Triplet>();
    for (int i = 1; i < n; i++) {
        int u = nextInt();
        int v = nextInt();
        int w = nextInt();
        list.add(new Triplet(u, v, w));
    }
    Collections.sort(list, new Comparator<Triplet>() {

        public int compare(Triplet a, Triplet b) {
            return a.third - b.third;
        }
    });
    // debug(list);
    parent = new int[n + 1];
    rank = new int[n + 1];
    size = new int[n + 1];
    for (int i = 1; i <= n; i++) {
        parent[i] = i;
        size[i] = 1;
    }
    ArrayList<Pair> queries = new ArrayList<>();
    queries.add(null);
    for (int i = 1; i <= m; i++) queries.add(new Pair(nextInt(), i));
    Collections.sort(queries.subList(1, m + 1), new Comparator<Pair>() {

        public int compare(Pair a, Pair b) {
            return a.first - b.first;
        }
    });
    long[] ans = new long[m + 1];
    int c = 0;
    long res = 0;
    for (int i = 1; i <= m; i++) {
        while (c <= n - 2 && queries.get(i).first >= list.get(c).third) {
            Triplet e = list.get(c++);
            res += 1l * size[find(e.first)] * size[find(e.second)];
            // debug("res",res);
            union(e.first, e.second);
        // debug("size",size[find(e.first)]);
        }
        ans[queries.get(i).second] = res;
    }
    for (int i = 1; i <= m; i++) out.print(ans[i] + " ");
}