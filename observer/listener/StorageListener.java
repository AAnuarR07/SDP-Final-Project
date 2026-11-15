package observer.listener;

import factory.product.Photo;

public class StorageListener implements PhotoListener {
    private final int limitKb;
    private int usedKb;

    public StorageListener(int limitKb, int usedKb) {
        this.limitKb = limitKb;
        this.usedKb = usedKb;
    }

    @Override
    public void onPhotoAdded(Photo photo) {
        usedKb += photo.getSizeKb();
        if (usedKb > limitKb) {
            System.out.println("[Observer] WARNING: storage limit exceeded (" + usedKb + " / " + limitKb + " KB)");
        } else {
            System.out.println("[Observer] Storage used: " + usedKb + " / " + limitKb + " KB");
        }
    }
}