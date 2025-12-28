
package com.harmonystream.dao;
import java.util.List;
import com.harmonystream.model.Music;
public interface MusicDAO {
 void uploadMusic(Music m);
 List<Music> approvedMusic();
}
