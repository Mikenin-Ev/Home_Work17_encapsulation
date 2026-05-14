package org.skypro.skyshop.Info;

import org.skypro.skyshop.Search.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return title + '\n' + content;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getSearchContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
