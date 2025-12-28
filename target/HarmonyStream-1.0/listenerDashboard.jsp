<%@ page import="java.util.*, com.harmonystream.daoimpl.MusicDAOImpl, com.harmonystream.model.Music" %>

<%
    MusicDAOImpl dao = new MusicDAOImpl();
    List<Music> songs = dao.approvedMusic();
%>

<html>
<head>
    <title>Listener Dashboard</title>
    <style>
        body {
            background: linear-gradient(135deg, #6a11cb, #2575fc);
            font-family: Arial;
            color: white;
        }
        table {
            width: 70%;
            margin: auto;
            background: white;
            color: black;
            border-radius: 10px;
            padding: 10px;
        }
        th, td {
            padding: 10px;
            text-align: center;
        }
        th {
            background: #2575fc;
            color: white;
        }
        h2 {
            text-align: center;
        }
    </style>
</head>

<body>

<h2>🎧 Listener Dashboard - Available Songs</h2>

<table>
<tr>
    <th>Title</th>
    <th>Album</th>
    <th>Genre</th>
</tr>

<% if (songs.isEmpty()) { %>
<tr>
    <td colspan="3">No music available</td>
</tr>
<% } else { %>
<% for (Music m : songs) { %>
<tr>
    <td><%= m.getTitle() %></td>
    <td><%= m.getAlbum() %></td>
    <td><%= m.getGenre() %></td>
</tr>
<% } %>
<% } %>

</table>

</body>
</html>
