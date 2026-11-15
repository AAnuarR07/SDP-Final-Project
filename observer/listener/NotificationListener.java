package observer.listener;

import factory.product.Photo;

public class NotificationListener implements PhotoListener {
    @Override
    public void onPhotoAdded(Photo photo) {
        System.out.println("[Observer] New photo added: " + photo.describe());
    }
}