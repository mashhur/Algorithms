package assessments.beamin;

import java.util.HashMap;
import java.util.Map;

public class FileSizes {

    enum FILE_TYPE {
        MUSIC,
        IMAGE,
        MOVIE,
        OTHER,
        UNKNOWN
    }

    public static void main(String[] args) {
        FileSizes fileSizes = new FileSizes();
        System.out.println(fileSizes.solution("my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b"));
    }

    public String solution(String S) {
        if (S == null || S.isEmpty())
            return "";

        String lines[] = S.split("\\r?\\n");
        Map<FILE_TYPE, Integer> map = initializeSizeMap();
        Map<FILE_TYPE, String[]> extensions = initializeExtensionMap();

        for (String line : lines) {
            String[] description = line.split("\\s+");
            FILE_TYPE fileType = getFileType(description[0], extensions); // file name
            int size = Integer.valueOf(description[1].substring(0, description[1].length() - 1)); // file size

            size = map.get(fileType) == null ? size : map.get(fileType) + size;
            map.put(fileType, size);
        }

        return makeResult(map);
    }

    private Map<FILE_TYPE, Integer> initializeSizeMap() {
        Map<FILE_TYPE, Integer> map = new HashMap<>();
        map.put(FILE_TYPE.OTHER, 0);
        map.put(FILE_TYPE.IMAGE, 0);
        map.put(FILE_TYPE.MOVIE, 0);
        map.put(FILE_TYPE.MUSIC, 0);
        return map;
    }

    private Map<FILE_TYPE, String[]> initializeExtensionMap() {
        Map<FILE_TYPE, String[]> map = new HashMap<>();
        String[] images = {"jpg", "bmp", "gif"};
        String[] musics = {"mp3", "aac", "flac"};
        String[] movies = {"mp4", "avi", "mkv"};
        //String[] other = {"7z", "txt", "zip"}; // no actually need

        map.put(FILE_TYPE.IMAGE, images);
        map.put(FILE_TYPE.MUSIC, musics);
        map.put(FILE_TYPE.MOVIE, movies);
        //map.put(FILE_TYPE.OTHER, other);

        return map;
    }

    private FILE_TYPE getFileType(String fileName, Map<FILE_TYPE, String[]> extensions) {
        for (Map.Entry<FILE_TYPE, String[]> entry : extensions.entrySet()) {
            for (String extension : entry.getValue()) {
                if (fileName.contains(extension))
                    return entry.getKey();
            }
        }
        return FILE_TYPE.OTHER;
    }

    private String makeResult(Map<FILE_TYPE, Integer> map) {
        String result = "";
        result += ("music " + map.get(FILE_TYPE.MUSIC) + "b\r\n");
        result += ("images " + map.get(FILE_TYPE.IMAGE) + "b\r\n");
        result += ("movies " + map.get(FILE_TYPE.MOVIE) + "b\r\n");
        result += ("other " + map.get(FILE_TYPE.OTHER) + "b\r\n");
        return result;
    }
}
