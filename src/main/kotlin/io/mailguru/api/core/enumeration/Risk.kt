package io.mailguru.api.core.enumeration

/**
 * Enumerates the expected risk level of an email sent to a specified address having a negative impact on the sender's
 * reputation.
 * <p>
 * Each single evaluation step may either have a positive (that is, expected) or negative (unexpected) outcome. While
 * the expected outcome always leads to a LOW risk, an unexpected outcome leads to different risk levels depending
 * on the specific check or heuristic performed. An unexpected outcome *may* lead to a LOW risk level, for example if an
 * email address has a valid syntax in terms of RFC 6531 ("SMTP Extension for Internationalized Email"), but is invalid
 * in terms of RFC 5322 ("Internet Message Format")
 */
enum class Risk {

    /**
     * Indicating a no/low risk level signal. This is the lowest possible risk level, so for example matching the RFC
     * 6531 email address syntax (that's the least you would expect from a valid email address) would be such a [LOW]
     * signal, whereas **not** matching the RFC 6531 syntax would be a [UNDELIVERABLE] signal.
     */
    LOW,

    /**
     * Signals of this level are produced by a best-guess heuristic. The evaluation result is neither safe positive nor
     * safe negative, but uncommon and therefore may have an impact on the sender's reputation. A good example for this
     * level is an ip address as the domain part of the evaluated email address: It's valid in terms of RFC, but it's
     * rarely seen in the wild and in most cases you don't want to accept such an email address.
     */
    MEDIUM,

    /**
     * This level would be used for signals indicating scammer, spambots, spamtraps, honeypots or email addresses
     * that will, to the best of our knowledge, lead to rejections or bounces and, thus, are highly suspicious to have
     * a negative impact on your sender reputation.
     */
    HIGH,

    /**
     * Used for signals indicating that emails to the address in question are undeliverable. For example, this may be a
     * failed RFC syntax check or an unregistered domain in the domain part of that address. For performance reasons
     * (and since the highest evaluated risk level will be given in the summary), the first evaluated [UNDELIVERABLE]
     * signal will cancel all subsequent checks.
     */
    UNDELIVERABLE,
}
