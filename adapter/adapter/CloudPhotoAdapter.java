package adapter.adapter;

import adapter.adaptee.CloudPhoto;
import factory.product.Photo;
import java.time.LocalDate;

public class CloudPhotoAdapter implements Photo {
    private final CloudPhoto cloudPhoto;

    public CloudPhotoAdapter(CloudPhoto cloudPhoto) {
        this.cloudPhoto = cloudPhoto;
    }

    @Override
    public String getName() {
        return cloudPhoto.getTitle();
    }

    @Override
    public String getFormat() {
        return "CLOUD";
    }

    @Override
    public int getSizeKb() {
        return (int) (cloudPhoto.getBytes() / 1024);
    }

    @Override
    public LocalDate getDate() {
        return LocalDate.parse(cloudPhoto.getUploadedOn());
    }
}