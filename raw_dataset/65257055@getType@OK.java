public static ContestType getType(Class<? extends AbstractSubmission> clss) {
    return getAnnotation(clss).value();
}