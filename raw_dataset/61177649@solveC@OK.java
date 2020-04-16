private void solveC() throws IOException {
    int minChar = 'z';
    for (char c : in.next().toCharArray()) {
        out.println(minChar < c ? "Ann" : "Mike");
        minChar = min(minChar, c);
    }
}