public static void ASSERT(boolean assertion) {
    if (!assertion)
        throw new AssertionError();
}