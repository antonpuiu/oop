package lab7.task1.document.text;

import lab7.task1.document.visitor.DocumentVisitor;

public abstract class TextSegment {
    private String content;

    TextSegment() {
        this("");
    }

    TextSegment(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public abstract void accept(DocumentVisitor visitor);
}
