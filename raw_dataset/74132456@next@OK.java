String next() {
    while (!st.hasMoreElements()) try {
        st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
        e.printStackTrace();
    }
    return st.nextToken();
}