public void assertTrue(boolean flag) {
    if (!allowDebug) {
        return;
    }
    if (!flag) {
        fail();
    }
}