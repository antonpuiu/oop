package lab5.task4;

import java.util.ArrayList;

public class BadAlbum extends Album {
    private boolean isPalindrome(int id) {
        ArrayList<Integer> digits = new ArrayList<>();

        while (id != 0) {
            digits.add(id % 10);
            id /= 10;
        }

        int last = digits.size() - 1;

        for (int i = 0; i < digits.size() / 2; i++)
            if (digits.get(i) != digits.get(last - i))
                return false;

        return true;
    }

    @Override
    void addSong(Song song) {
        if (song.getName().length() == 3 && isPalindrome(song.getId()))
            songs.add(song);
    }
}
