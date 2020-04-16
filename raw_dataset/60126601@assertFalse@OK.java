public void assertFalse(boolean flag) {
    if (!allowDebug) {
        return;
    }
    if (flag) {
        fail();
    }
}