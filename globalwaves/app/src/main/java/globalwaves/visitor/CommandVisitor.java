package globalwaves.visitor;

public interface CommandVisitor extends
        SearchBarCommandVisitor,
        PlayerCommandVisitor,
        PlaylistCommandVisitor,
        UsersCommandVisitor,
        GeneralCommandVisitor {
}
