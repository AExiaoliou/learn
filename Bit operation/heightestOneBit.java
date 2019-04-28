//from java.lang.Integer.hightestOneBit()
/**
 * Returns an {@code int} value with at most a single one-bit, in the
 * position of the highest-order ("leftmost") one-bit in the specified
 * {@code int} value.  Returns zero if the specified value has no
 * one-bits in its two's complement binary representation, that is, if it
 * is equal to zero.
 *
 * @param i the value whose highest one bit is to be computed
 * @return an {@code int} value with a single one-bit, in the position
 *     of the highest-order one-bit in the specified value, or zero if
 *     the specified value is itself equal to zero.
 * @since 1.5
 */
public static int highestOneBit(int i) {
    // HD, Figure 3-1
    i |= (i >>  1);
    i |= (i >>  2);
    i |= (i >>  4);
    i |= (i >>  8);
    i |= (i >> 16);
    return i - (i >>> 1);
}
