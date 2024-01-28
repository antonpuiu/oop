package globalwaves.visitor.command;

public interface CommandVisitor extends
                SearchBarCommandVisitor,
                PlayerCommandVisitor,
                PlaylistCommandVisitor,
                UsersCommandVisitor,
                GeneralCommandVisitor {
}
