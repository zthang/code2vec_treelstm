private String nextToken() throws IndexOutOfBoundsException, IOException {
    if (index == s.length) {
        s = br.readLine().split(" ");
        index = 0;
    }
    return s[index++];
}