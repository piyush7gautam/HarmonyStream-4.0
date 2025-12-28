<html>
<head>
    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body>
    <div class="card">
        <h2>Harmony Stream Login</h2>

        <form action="<%= request.getContextPath() %>/login" method="post">
    <input type="text" name="email" placeholder="Email" required><br>
    <input type="password" name="password" placeholder="Password" required><br>
    <button type="submit">Login</button>
</form>


    </div>
</body>
</html>
