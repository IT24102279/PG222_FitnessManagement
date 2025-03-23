<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Details</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="p-4">
<h2 class="text-2xl mb-4">Update Your Details</h2>
<form action="/update" method="post">
    <div class="mb-4">
        <label class="block text-gray-700">Username (cannot change):</label>
        <input type="text" value="${user.username}" class="border p-2 w-full" disabled/>
    </div>
    <div class="mb-4">
        <label class="block text-gray-700">Password:</label>
        <input type="password" name="password" value="${user.password}" class="border p-2 w-full" required/>
    </div>
    <div class="mb-4">
        <label class="block text-gray-700">Email:</label>
        <input type="email" name="email" value="${user.email}" class="border p-2 w-full" required/>
    </div>
    <div class="mb-4">
        <label class="block text-gray-700">Role (cannot change):</label>
        <input type="text" value="${user.role}" class="border p-2 w-full" disabled/>
    </div>
    <button type="submit" class="bg-green-500 text-white p-2 w-full">Save Changes</button>
    <c:if test="${not empty error}">
        <p class="text-red-500 mt-2">${error}</p>
    </c:if>
</form>
<a href="/profile" class="mt-4 inline-block bg-gray-500 text-white p-2 rounded">Back to Profile</a>
</body>
</html>