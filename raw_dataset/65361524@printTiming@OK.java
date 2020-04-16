public static <T, E extends Throwable> T printTiming(ThrowingSupplier<T, E> supplier) throws E {
    return printTiming(supplier, null);
}