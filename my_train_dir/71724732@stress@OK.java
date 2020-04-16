void stress() {
    for (int tst = 0; ; tst++) {
        if (false) {
            throw new AssertionError();
        }
        System.err.println(tst);
    }
}