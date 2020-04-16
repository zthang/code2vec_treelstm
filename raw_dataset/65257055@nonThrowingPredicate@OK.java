public static <T> Predicate<T> nonThrowingPredicate(ThrowingPredicate<T, ?> r) {
    return (a) -> {
        try {
            return r.test(a);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    };
}