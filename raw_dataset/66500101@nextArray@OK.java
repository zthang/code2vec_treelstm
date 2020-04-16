static Integer[] nextArray(int n) throws IOException {
    StringTokenizer st = new StringTokenizer(in.readLine());
    Integer[] tmp = new Integer[n];
    for (int i = 0; i < tmp.length; i++) {
        tmp[i] = Integer.parseInt(st.nextToken());
    }
    return tmp;
}