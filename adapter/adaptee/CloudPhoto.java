package adapter.adaptee;

public class CloudPhoto {
    private final String title;
    private final long bytes;
    private final String uploadedOn;

    public CloudPhoto(String title, long bytes, String uploadedOn) {
        this.title = title;
        this.bytes = bytes;
        this.uploadedOn = uploadedOn;
    }

    public String getTitle() {
        return title;
    }

    public long getBytes() {
        return bytes;
    }

    public String getUploadedOn() {
        return uploadedOn;
    }
}