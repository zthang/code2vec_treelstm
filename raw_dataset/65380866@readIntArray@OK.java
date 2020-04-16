int[] readIntArray(int n) throws IOException {
    int[] answer = new int[n];
    for (int i = 0; i < n; ++i) {
        answer[i] = nextInt();
    }
    return answer;
}