private void times(int n, IntConsumer consumer) {
    for (int i = 0; i < n; i++) {
        try {
            consumer.accept(i);
        } catch (ExitException ignored) {
        }
    }
}