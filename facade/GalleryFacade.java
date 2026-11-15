package facade;

import adapter.adaptee.CloudPhoto;
import adapter.adapter.CloudPhotoAdapter;
import builder.builder.AlbumBuilder;
import builder.product.Album;
import factory.creator.JpegPhotoFactory;
import factory.creator.PhotoFactory;
import factory.creator.PngPhotoFactory;
import factory.creator.RawPhotoFactory;
import factory.product.Photo;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import observer.listener.NotificationListener;
import observer.listener.StorageListener;
import observer.subject.PhotoPublisher;
import strategy.context.GallerySorter;
import strategy.strategy.SortStrategy;

public class GalleryFacade {
    private final Map<String, PhotoFactory> factories = new HashMap<>();
    private final PhotoPublisher publisher = new PhotoPublisher();
    private final GallerySorter sorter = new GallerySorter();
    private final Album album;

    public GalleryFacade() {
        factories.put("JPEG", new JpegPhotoFactory());
        factories.put("PNG", new PngPhotoFactory());
        factories.put("RAW", new RawPhotoFactory());

        album = new AlbumBuilder()
                .name("Country Travel")
                .description("Photos from the travel on the coutry")
                .addPhoto(factories.get("JPEG").create("Lake", 2400, LocalDate.of(2026, 7, 10)))
                .addPhoto(factories.get("PNG").create("Almaty", 800, LocalDate.of(2026, 7, 12)))
                .addPhoto(factories.get("RAW").create("Mountain", 7800, LocalDate.of(2026, 7, 15)))
                .build();

        publisher.attach(new NotificationListener());
        publisher.attach(new StorageListener(15000, album.getTotalSizeKb()));
    }

    public void addPhoto(String format, String name, int sizeKb, String date) {
        Photo photo = factories.get(format).create(name, sizeKb, LocalDate.parse(date));
        store(photo);
    }

    public void importFromCloud(String title, long bytes, String uploadedOn) {
        Photo photo = new CloudPhotoAdapter(new CloudPhoto(title, bytes, uploadedOn));
        System.out.println("[Adapter] Imported " + photo.describe());
        store(photo);
    }

    public void showSorted(SortStrategy strategy) {
        sorter.setStrategy(strategy);
        List<Photo> sorted = sorter.sort(album.getPhotos());
        for (Photo photo : sorted) {
            System.out.println("  " + photo.describe());
        }
    }

    public void printAlbum() {
        System.out.println("Album of " + album.getName() + ": " + album.getDescription()
                + " (" + album.getPhotos().size() + " photos, " + album.getTotalSizeKb() + " KB)");
        for (Photo photo : album.getPhotos()) {
            System.out.println("  " + photo.describe());
        }
    }

    private void store(Photo photo) {
        album.addPhoto(photo);
        publisher.publishAdded(photo);
    }
}