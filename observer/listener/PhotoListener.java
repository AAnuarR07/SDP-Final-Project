package observer.listener;

import factory.product.Photo;

public interface PhotoListener {
    void onPhotoAdded(Photo photo);
}