package observer.subject;

import factory.product.Photo;
import java.util.ArrayList;
import java.util.List;
import observer.listener.PhotoListener;

public class PhotoPublisher {
    private final List<PhotoListener> listeners = new ArrayList<>();

    public void attach(PhotoListener listener) {
        listeners.add(listener);
    }

    public void detach(PhotoListener listener) {
        listeners.remove(listener);
    }

    public void publishAdded(Photo photo) {
        for (PhotoListener listener : listeners) {
            listener.onPhotoAdded(photo);
        }
    }
}