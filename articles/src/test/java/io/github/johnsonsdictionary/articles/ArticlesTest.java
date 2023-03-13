package io.github.johnsonsdictionary.articles;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArticlesTest {

    @Test
    public void testArticlesLoad() {
        Assertions.assertEquals(2, Articles.ALL_ARTICLES.keySet().size());
    }
}
