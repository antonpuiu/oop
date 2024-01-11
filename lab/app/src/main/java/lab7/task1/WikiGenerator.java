package lab7.task1;

import lab7.task1.document.text.TextSegment;

import lab7.task1.document.visitor.DocumentVisitor;
import lab7.task1.document.visitor.DokuWikiVisitor;
import lab7.task1.document.visitor.MarkdownVisitor;

import java.util.List;

/**
 * Uses visitors to parse documents and provide dokuwiki and markdown outputs.
 */
public class WikiGenerator {
    private final List<TextSegment> textSegments;

    public WikiGenerator(List<TextSegment> textSegments) {
        this.textSegments = textSegments;
    }

    public StringBuilder getDokuWikiDocument() {
        DocumentVisitor visitor = new DokuWikiVisitor();

        for (TextSegment segment : textSegments)
            segment.accept(visitor);

        return visitor.getDocument();
    }

    public StringBuilder getMarkdownDocument() {
        DocumentVisitor visitor = new MarkdownVisitor();

        for (TextSegment segment : textSegments)
            segment.accept(visitor);

        return visitor.getDocument();
    }
}
