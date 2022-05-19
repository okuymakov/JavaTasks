package ru.kuymakov.comments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comment {

    private String text;
    private int rating;
    private List<Comment> comments;
    private String divider;
    public Comment(String text, int rating) {
        this.text = text;
        this.rating = rating;
        comments = new ArrayList<>();
        divider = "";
    }

    Comment(Comment comment) {
        this(comment.text, comment.rating);
        this.comments = comment.comments;
    }

    public void addComments(Comment... comments) {
        this.comments.addAll(Arrays.asList(comments));
    }

    public String getText() {
        return text;
    }

    public int getRating() {
        return rating;
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }
    
    @Override
    public String toString() {
        String res = "(" + rating + ") " + text;
        String divider = this.divider;
        if (!comments.isEmpty()) {
            divider += "---";
            for (Comment c : comments) {
                c.divider = divider;
                res += "\n" + divider + c;
            }
        }
        return res;
    }
}
