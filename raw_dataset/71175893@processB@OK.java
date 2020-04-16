static void processB() {
    link = new Link[N];
    link[0] = new Link(0);
    int m = 0;
    int curr = 0;
    for (int i = 0; i < N - 1; i++) {
        if (comp.charAt(i) == '>') {
            Link l = new Link(i + 1);
            l.b = link[curr].b;
            l.a = link[curr];
            if (link[curr].b != null) {
                link[curr].b.a = l;
            }
            link[curr].b = l;
            link[i + 1] = l;
            curr = i + 1;
        } else {
            Link l = new Link(i + 1);
            l.b = link[m];
            link[m].a = l;
            m = i + 1;
            link[i + 1] = l;
            curr = m;
        }
    }
    int[] ans = new int[N];
    Link c = link[m];
    for (int i = 0; i < N; i++) {
        ans[c.i] = N - i;
        c = c.b;
    }
    for (int i = 0; i < N - 1; i++) {
        System.out.print(ans[i] + " ");
    }
    System.out.println(ans[N - 1]);
}