package lab5.task4;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Song song1 = new Song("Bad", 101, "Michael Jackson");
        Song song2 = new Song("Dangerous", 19, "Michael Jackson");
        Song song3 = new Song("Heal the world", 53, "Composer");
        Song song4 = new Song("Thriller", 82, "Michael Jackson" );
        Song song5 = new Song("Beat it", 83, "Michel Jakson");
        Song song6 = new Song("Smooth Criminal", 77, "Composer");

        DangerousAlbum dangerous = new DangerousAlbum();
        dangerous.addSong(song2);
        dangerous.addSong(song3);
        dangerous.addSong(song6);
        System.out.println(dangerous);

        ThrillerAlbum thriller = new ThrillerAlbum();
        thriller.addSong(song4);
        thriller.addSong(song6);
        thriller.addSong(song5);
        System.out.println(thriller);

        BadAlbum bad = new BadAlbum();
        bad.addSong(song1);
        bad.addSong(song6);
        System.out.println(bad);
    }

    @Override
    public int getId() {
        return 4;
    }
}
