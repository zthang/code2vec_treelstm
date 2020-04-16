void parse(Scanner sc) {
    n = sc.nextInt();
    for (int i = 1; i <= n; i++) edges.put(i, new HashSet<>());
    m = sc.nextInt();
    for (int i = 0; i < m; i++) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        edges.get(a).add(b);
        edges.get(b).add(a);
    }
}