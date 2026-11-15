import facade.GalleryFacade;
import strategy.concrete.SortByDate;
import strategy.concrete.SortByName;
import strategy.concrete.SortBySize;

public class Main {
    public static void main(String[] args) {
        GalleryFacade gallery = new GalleryFacade();

        System.out.println("\n");
        gallery.printAlbum();

        System.out.println("\n");
        gallery.addPhoto("JPEG", "Screenshot", 3200, "2026-08-02");
        gallery.importFromCloud("Dinner at relatives house", 5242880, "2026-07-30");

        System.out.println("\n");
        gallery.printAlbum();

        System.out.println("\n");
        gallery.showSorted(new SortByName());
        gallery.showSorted(new SortByDate());
        gallery.showSorted(new SortBySize());
    }
}