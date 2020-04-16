public int solve() {
    UnionFind unionFind = new UnionFind(n + 1);
    for (int[] ab : abs) {
        int a = ab[0];
        int b = ab[1];
        unionFind.merge(a, b);
    }
    int answer = 0;
    int index = 1;
    while (index <= n) {
        int maxIndex = unionFind.getMax(index);
        int i = index + 1;
        while (i < maxIndex) {
            if (!unionFind.sameGroup(index, i)) {
                unionFind.merge(index, i);
                answer++;
                maxIndex = unionFind.getMax(index);
            }
            i++;
        }
        index = maxIndex + 1;
    }
    return answer;
}