package client;

public class DeleteResult {
    private final FileStatus status;
    private final String fileName;

    public FileStatus getStatus() {
        return status;
    }

    public String getFileName() {
        return fileName;
    }

    private DeleteResult(FileStatus status, String fileName) {
        this.status = status;
        this.fileName = fileName;
    }

    public static DeleteResult of(FileStatus status, String fileName) {
        return new DeleteResult(status, fileName);
    }
}
