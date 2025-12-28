
package com.harmonystream.model;
public class Music {
 private int id,artistId,streams;
 private String title,album,genre,status;
 public int getId(){return id;}
 public void setId(int id){this.id=id;}
 public String getTitle(){return title;}
 public void setTitle(String title){this.title=title;}
 public String getAlbum(){return album;}
 public void setAlbum(String album){this.album=album;}
 public String getGenre(){return genre;}
 public void setGenre(String genre){this.genre=genre;}
 public int getArtistId(){return artistId;}
 public void setArtistId(int artistId){this.artistId=artistId;}
 public int getStreams(){return streams;}
 public void setStreams(int streams){this.streams=streams;}
 public String getStatus(){return status;}
 public void setStatus(String status){this.status=status;}
}
