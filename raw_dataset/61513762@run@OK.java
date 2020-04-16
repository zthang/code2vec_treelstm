private void run() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String[] line = reader.readLine().split("\\s");
    int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
    int[] id = new int[n];
    Random random = new Random();
    for (int i = 0; i < n; i++) {
        id[i] = random.nextInt();
    }
    int[] hash = new int[n];
    for (int i = 0; i < m; i++) {
        line = reader.readLine().split("\\s");
        int a = Integer.parseInt(line[0]) - 1, b = Integer.parseInt(line[1]) - 1;
        hash[a] ^= id[b];
        hash[b] ^= id[a];
    }
    Set<Integer> groups = new HashSet<>();
    for (int i = 0; i < n; i++) {
        groups.add(hash[i]);
    }
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    if (groups.size() != 3 || groups.contains(0))
        System.out.println(-1);
    else {
        HashMap<Integer, Integer> num = new HashMap<>();
        int k = 1;
        for (int e : groups) {
            num.put(e, k++);
        }
        for (int i = 0; i < n; i++) {
            writer.write(num.get(hash[i]) + " ");
        }
    }
    writer.flush();
}