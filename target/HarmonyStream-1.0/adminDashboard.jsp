<%@ page import="java.util.*" %>
<%@ page import="com.harmonystream.daoimpl.MusicDAOImpl" %>
<%@ page import="com.harmonystream.model.Music" %>

<h1>Admin Dashboard – Pending Music</h1>

<table border="1" cellpadding="10">
<tr>
    <th>Title</th>
    <th>Album</th>
    <th>Genre</th>
    <th>Action</th>
</tr>

<%
    MusicDAOImpl dao = new MusicDAOImpl();
    List<Music> list = dao.pendingMusic();

    for (Music m : list) {
%>
<tr>
    <td><%= m.getTitle() %></td>
    <td><%= m.getAlbum() %></td>
    <td><%= m.getGenre() %></td>
    <td>
        <form action="adminMusicAction" method="post" style="display:inline">
            <input type="hidden" name="musicId" value="<%= m.getId() %>">
            <input type="hidden" name="action" value="APPROVED">
            <button>Approve</button>
        </form>

        <form action="adminMusicAction" method="post" style="display:inline">
            <input type="hidden" name="musicId" value="<%= m.getId() %>">
            <input type="hidden" name="action" value="REJECTED">
            <button>Reject</button>
        </form>
    </td>
</tr>
<%
    }
%>
</table>
