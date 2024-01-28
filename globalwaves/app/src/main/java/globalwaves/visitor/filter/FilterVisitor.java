package globalwaves.visitor.filter;

import globalwaves.fileio.input.library.SongInput;

public interface FilterVisitor {
    boolean visit(SongInput song);
}
