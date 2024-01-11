package lab7.task1.document.text;

import lab7.task1.document.visitor.DocumentVisitor;

public class UrlSegment extends TextSegment {
    private String url;
    private String description;

    public UrlSegment(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}
