package org.rjung.util.gravatar;

/**
 * Gravatar allows users to self-rate their images so that they can indicate if
 * an image is appropriate for a certain audience. By default, only 'G' rated
 * images are displayed unless you indicate that you would like to see higher
 * ratings.
 */
public enum Rating {
    /**
     * Suitable for display on all websites with any audience type.
     */
    G("g"),
    /**
     * May contain rude gestures, provocatively dressed individuals, the lesser
     * swear words, or mild violence.
     */
    PG("pg"),
    /**
     * May contain such things as harsh profanity, intense violence, nudity, or
     * hard drug use.
     */
    R("r"),
    /**
     * May contain hardcore sexual imagery or extremely disturbing violence.
     */
    X("x");

    private String code;

    Rating(final String pCode) {
        this.code = pCode;
    }

    /**
     * Get the string representation of the {@link Rating} for gravatar.
     * @returns The string-representation of the {@link Rating} for gravatar.
     */
    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}
