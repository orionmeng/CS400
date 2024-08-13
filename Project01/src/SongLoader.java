import java.util.List;
import java.io.FileNotFoundException;
// interface
interface SongLoaderInterface {
    public List<SongDataInterface> loadFile(String csvFilePath) throws FileNotFoundException;
    public List<SongDataInterface> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException;
}
// public class
public class SongLoader implements SongLoaderInterface {
    @Override
    public List<SongDataInterface> loadFile(String csvFilePath) throws FileNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<SongDataInterface> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
}
