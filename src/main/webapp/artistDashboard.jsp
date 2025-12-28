<%@ page import="com.harmonystream.model.User"%>
<%
User u = (User) session.getAttribute("user");
if (u == null || !"ARTIST".equals(u.getRole())) {
    response.sendRedirect("login.jsp");
    return;
}
%>

<html>
<body>
<div class="card">
<h2>Artist Dashboard</h2>

<form action="<%=request.getContextPath()%>/upload" method="post">
    <input name="title" placeholder="Song Title" required>
    <input name="album" placeholder="Album" required>
    <input name="genre" placeholder="Genre" required>
    <button type="submit">Upload</button>
</form>

</div>
</body>
</html>
