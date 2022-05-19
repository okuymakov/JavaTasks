package ru.kuymakov.comments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Publication {

    private String title;
    private String text;
    private String[] tags;
    private List<Comment> comments;
    private int rating;
    private boolean isCommented = false;
    private boolean ratingWasChanged = false;

    public Publication(String title, String text, String[] tags, int rating) {
        this.title = title;
        this.text = text;
        this.tags = Arrays.copyOf(tags, tags.length);;
        this.rating = rating;
        this.comments = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String[] getTags() {
        return Arrays.copyOf(tags, tags.length);
    }

    public void addComments(Comment... comments) {
        this.comments.addAll(Arrays.asList(comments));
        isCommented = true;
    }

    public void setComments(Comment... comments) {
        if (isCanBeChanged()) {
            this.comments = new ArrayList<>(Arrays.asList(comments));
        } else {
            throw new IllegalArgumentException("Комментировать публикацию запрещено");
        }
    }

    public void setText(String text) {
        if (isCanBeChanged()) {
            this.text = text;
        } else {
            throw new IllegalArgumentException("Изменять текст публикации запрещено");
        }
    }

    public int getRating() {
        return rating;
    }

    public boolean isCanBeChanged() {
        return !isCommented && !ratingWasChanged;
    }

    public void increaseRating() {
        ratingWasChanged = true;
        rating++;
    }

    public void decreaseRating() {
        ratingWasChanged = true;
        rating--;
    }

    @Override
    public String toString() {
        String scomments = "";
        for (Comment c : comments) {
            scomments += "\n" + c;
        }

        return "(" + rating + ") " + title + "\n" + "тэги: "
                + String.join(",", tags) + "\n" + text + scomments;
    }

}
