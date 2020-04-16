public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    int M = in.nextInt();
    Items[] items = new Items[N];
    int sum = 0;
    ArrayList<String> ans = new ArrayList<>();
    for (int i = 0; i < N; i++) {
        items[i] = new Items(i + 1, in.nextInt());
        sum += items[i].value * 2;
        if (i < N - 1) {
            ans.add((i + 1) + " " + (i + 2));
        } else {
            ans.add((i + 1) + " 1");
        }
    }
    if (N == 2 || N > M) {
        out.printLine(-1);
        return;
    }
    Arrays.sort(items, new Comparator<Items>() {

        public int compare(Items o1, Items o2) {
            if (o1.value != o2.value) {
                return o1.value - o2.value;
            }
            return o1.index - o2.index;
        }
    });
    for (int i = N + 1; i <= M; i++) {
        sum += items[0].value + items[1].value;
        ans.add(items[0].index + " " + items[1].index);
    }
    out.printLine(sum);
    for (String s : ans) {
        out.printLine(s);
    }
}