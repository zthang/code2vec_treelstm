public char nextChar() {
    try {
        int b = input.read();
        while (Character.isWhitespace(b)) {
            b = input.read();
        }
        return (char) b;
    } catch (IOException e) {
        e.printStackTrace();
        return 0;
    }
}