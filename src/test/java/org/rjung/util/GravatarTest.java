package org.rjung.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import junit.framework.TestCase;

import org.junit.Test;
import org.rjung.util.gravatar.Default;
import org.rjung.util.gravatar.Rating;

public class GravatarTest extends TestCase {

    private static final String EXAMPLE_EMAIL = "example@example.com";
    private static final String GRAVATAR_URL_FOR_EXAMPLE_EMAIL = "http://www.gravatar.com/avatar/23463B99B62A72F26ED677CC556C44E8";

    @Test
    public void testInstanceDoesEncodeExampleEmailCorrectly() {
        assertThat(Gravatar.getInstance().imageUrl(EXAMPLE_EMAIL),
                equalTo(GRAVATAR_URL_FOR_EXAMPLE_EMAIL));
    }

    @Test
    public void testInstanceDoesTrimExampleEmail() {
        assertThat(
                Gravatar.getInstance().imageUrl(
                        "     example@example.com            "),
                equalTo(GRAVATAR_URL_FOR_EXAMPLE_EMAIL));
    }

    @Test
    public void testInstanceDoesLowercaseExampleEmail() {
        assertThat(Gravatar.getInstance().imageUrl("eXaMpLe@eXaMpLe.cOm"),
                equalTo(GRAVATAR_URL_FOR_EXAMPLE_EMAIL));
    }

    @Test
    public void testNotDefinedEmailDoesNotRaiseExceptions() {
        Gravatar.getInstance().imageUrl(null);
    }

    @Test
    public void testGravatarWithSize() {
        assertThat(Gravatar.getInstance().imageUrl(EXAMPLE_EMAIL, 123),
                equalTo(GRAVATAR_URL_FOR_EXAMPLE_EMAIL + "?s=123"));
    }

    @Test
    public void testGravatarWithSizeAndDefault() {
        assertThat(
                Gravatar.getInstance().imageUrl(EXAMPLE_EMAIL, 123,
                        Default.MONSTERID),
                equalTo(GRAVATAR_URL_FOR_EXAMPLE_EMAIL + "?s=123&d=monsterid"));
    }

    @Test
    public void testGravatarWithDefault() {
        assertThat(
                Gravatar.getInstance().imageUrl(EXAMPLE_EMAIL,
                        Default.MONSTERID),
                equalTo(GRAVATAR_URL_FOR_EXAMPLE_EMAIL + "?d=monsterid"));
    }

    @Test
    public void testGravatarWithDefaultAndRating() {
        assertThat(
                Gravatar.getInstance().imageUrl(EXAMPLE_EMAIL,
                        Default.MONSTERID, Rating.R),
                equalTo(GRAVATAR_URL_FOR_EXAMPLE_EMAIL + "?d=monsterid&r=r"));
    }

    @Test
    public void testGravatarWithRating() {
        assertThat(Gravatar.getInstance().imageUrl(EXAMPLE_EMAIL, Rating.PG),
                equalTo(GRAVATAR_URL_FOR_EXAMPLE_EMAIL + "?r=pg"));
    }

    @Test
    public void testGravatarWithSizeDefaultAndRating() {
        assertThat(
                Gravatar.getInstance().imageUrl(EXAMPLE_EMAIL, 123,
                        Default.MONSTERID, Rating.X),
                equalTo(GRAVATAR_URL_FOR_EXAMPLE_EMAIL
                        + "?s=123&d=monsterid&r=x"));
    }
}