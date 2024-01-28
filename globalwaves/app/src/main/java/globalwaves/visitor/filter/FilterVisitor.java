package globalwaves.visitor.filter;

import globalwaves.entity.AudioFile;

public interface FilterVisitor {
    boolean visit(AudioFile song);
}
