private void solveA() throws IOException {
    int n = in.nextInt();
    int[] cnt = new int[2];
    for (char c : in.next().toCharArray()) if (c == 'z')
        cnt[0]++;
    else if (c == 'o')
        cnt[1]++;
    cnt[1] -= cnt[0];
    for (int i = 1; i >= 0; i--) {
        while (cnt[i]-- > 0) out.print(i + " ");
    }
}