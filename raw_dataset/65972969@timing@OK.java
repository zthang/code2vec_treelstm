public static <E extends Throwable> double timing(ThrowingRunnable<E> runnable) throws E {
    long start = System.nanoTime();
    runnable.run();
    long end = System.nanoTime();
    return (end - start) / 1_000_000_000.0;
}