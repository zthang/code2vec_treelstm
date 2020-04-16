private long score(int[] colorPerm, List<Integer> vertices) {
    long sum = 0;
    for (int i = 0; i < vertices.size(); i++) {
        sum += c[colorPerm[i % 3]][vertices.get(i)];
    }
    return sum;
}