package com.harmonystream.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.harmonystream.dao.MusicDAO;
import com.harmonystream.model.Music;
import com.harmonystream.util.DBConnection;

public class MusicDAOImpl implements MusicDAO {

    // Artist uploads music (default PENDING)
    @Override
    public void uploadMusic(Music m) {
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement p = c.prepareStatement(
                "INSERT INTO music(title, album, genre, artist_id, status) VALUES (?, ?, ?, ?, 'PENDING')"
            );
            p.setString(1, m.getTitle());
            p.setString(2, m.getAlbum());
            p.setString(3, m.getGenre());
            p.setInt(4, m.getArtistId());
            p.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ LISTENER: View approved music
    public List<Music> approvedMusic() {
        List<Music> list = new ArrayList<>();
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(
                "SELECT * FROM music WHERE status='APPROVED'"
            );
            ResultSet r = ps.executeQuery();

            while (r.next()) {
                Music m = new Music();
                m.setId(r.getInt("id"));
                m.setTitle(r.getString("title"));
                m.setAlbum(r.getString("album"));
                m.setGenre(r.getString("genre"));
                m.setArtistId(r.getInt("artist_id"));
                m.setStreams(r.getInt("streams"));
                m.setStatus(r.getString("status"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ADMIN: View pending music
    public List<Music> pendingMusic() {
        List<Music> list = new ArrayList<>();
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(
                "SELECT * FROM music WHERE status='PENDING'"
            );
            ResultSet r = ps.executeQuery();

            while (r.next()) {
                Music m = new Music();
                m.setId(r.getInt("id"));
                m.setTitle(r.getString("title"));
                m.setAlbum(r.getString("album"));
                m.setGenre(r.getString("genre"));
                m.setArtistId(r.getInt("artist_id"));
                m.setStreams(r.getInt("streams"));
                m.setStatus(r.getString("status"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ADMIN: Approve / Reject
    public void updateStatus(int musicId, String status) {
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(
                "UPDATE music SET status=? WHERE id=?"
            );
            ps.setString(1, status);
            ps.setInt(2, musicId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
