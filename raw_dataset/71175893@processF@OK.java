static void processF() {
    link = new Link[N];
    link[0] = new Link(0);
    int m = 0;
    int curr = 0;
    for (int i = 0; i < N - 1; i++) {
        if (comp.charAt(i) == '<') {
            Link l = new Link(i + 1);
            l.a = link[curr].a;
            l.b = link[curr];
            if (link[curr].a != null) {
                link[curr].a.b = l;
            }
            link[curr].a = l;
            link[i + 1] = l;
            curr = i + 1;
        } else {
            Link l = new Link(i + 1);
            l.a = link[m];
            link[m].b = l;
            m = i + 1;
            link[i + 1] = l;
            curr = m;
        }
    }
    int[] ans = new int[N];
    Link c = link[m];
    for (int i = 0; i < N; i++) {
        ans[c.i] = i + 1;
        c = c.a;
    }
    for (int i = 0; i < N - 1; i++) {
        System.out.print(ans[i] + " ");
    }
    System.out.println(ans[N - 1]);
}