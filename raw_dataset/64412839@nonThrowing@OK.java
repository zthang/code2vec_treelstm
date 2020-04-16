public static <T, R> Function<T, R> nonThrowing(ThrowingFunction<T, R, ?> r) {
    return (a) -> {
        try {
            return r.apply(a);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    };
}