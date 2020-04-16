public String next() throws Exception {
    if (input == null || input.length == id) {
        input = br.readLine().split(" ");
        id = 0;
    }
    return input[id++];
}