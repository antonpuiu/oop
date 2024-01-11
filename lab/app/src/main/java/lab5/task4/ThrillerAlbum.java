package lab5.task4;

public class ThrillerAlbum extends Album {
    @Override
    void addSong(Song song) {
        if (song.getComposer().equals("Michael Jackson") && song.getId() % 2 == 0)
            songs.add(song);
    }
}
