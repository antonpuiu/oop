package lab7.task1.document.visitor;

import lab7.task1.document.text.BoldTextSegment;
import lab7.task1.document.text.ItalicTextSegment;
import lab7.task1.document.text.PlainTextSegment;
import lab7.task1.document.text.UrlSegment;

public class DokuWikiVisitor extends DocumentVisitor {
    @Override
    public void visit(ItalicTextSegment segment) {
        document.append("//" + segment.getContent() + "//");
    }

    @Override
    public void visit(BoldTextSegment segment) {
        document.append("**" + segment.getContent() + "**");
    }

    @Override
    public void visit(PlainTextSegment segment) {
        document.append(segment.getContent());
    }

    @Override
    public void visit(UrlSegment segment) {
        document.append("[[" + segment.getUrl() + "|" + segment.getDescription() + "]]");
    }
}
