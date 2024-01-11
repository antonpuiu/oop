package lab5.task4;

public class DangerousAlbum extends Album {
    private boolean isPrime(int value) {
        for (int i = 2; i <= Math.sqrt(value); i++)
            if (value % i == 0)
                return false;

        return true;
    }
    @Override
    void addSong(Song song) {
        if (isPrime(song.getId()))
            songs.add(song);
    }
}
