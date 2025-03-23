<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="p-4">
<h2 class="text-2xl mb-4">Login</h2>
<form action="/login" method="post">
    <div class="mb-4">
        <input type="text" name="username" placeholder="Username" class="border p-2 w-full" required/>
    </div>
    <div class="mb-4">
        <input type="password" name="password" placeholder="Password" class="border p-2 w-full" required/>
    </div>
    <button type="submit" class="bg-blue-500 text-white p-2 w-full">Login</button>
    <c:if test="${not empty error}">
        <p class="text-red-500 mt-2">${error}</p>
    </c:if>
</form>
</body>
</html>