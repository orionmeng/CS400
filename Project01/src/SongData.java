// interface
interface SongDataInterface {
    public String getTitle();
    public String getArtist();
    public int getYearPublished();
}
// public class
public class SongData implements SongDataInterface {
    private String title;
    private String artist;
    private int year;
  public SongData(String title, String artist, int year) {
    this.title = title;
    this.artist = artist;
    this.year = year;
  }
    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getArtist() {
        return artist;
    }
    @Override
    public int getYearPublished() {
        return year;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return "(title: " + title + ") (artist: " + artist + ") (year: " + year + ")\n";
    }
}
