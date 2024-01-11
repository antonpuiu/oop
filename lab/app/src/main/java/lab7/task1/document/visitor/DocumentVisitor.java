package lab7.task1.document.visitor;

import lab7.task1.document.text.BoldTextSegment;
import lab7.task1.document.text.ItalicTextSegment;
import lab7.task1.document.text.PlainTextSegment;
import lab7.task1.document.text.UrlSegment;

public abstract class DocumentVisitor {
    protected StringBuilder document;

    public DocumentVisitor() {
        document = new StringBuilder();
    }

    public StringBuilder getDocument() {
        return document;
    }

    public abstract void visit(ItalicTextSegment segment);
    public abstract void visit(BoldTextSegment segment);
    public abstract void visit(PlainTextSegment segment);
    public abstract void visit(UrlSegment segment);
}
