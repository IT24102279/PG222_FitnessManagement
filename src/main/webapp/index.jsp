<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fitness Center Management</title>
    <!-- You can add Bootstrap or any CSS here for styling -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mt-5">Welcome to the Fitness Center Management</h1>
    <p class="lead">Manage memberships, renewals, and more.</p>

    <div class="row mt-4">
        <div class="col-md-4">
            <h3>Register New Member</h3>
            <p>Create a new member for the fitness center.</p>
            <a href="register.jsp" class="btn btn-primary">Register</a>
        </div>

        <div class="col-md-4">
            <h3>View Members</h3>
            <p>See all the current members in the system.</p>
            <a href="members.jsp" class="btn btn-info">View Members</a>
        </div>

        <div class="col-md-4">
            <h3>Renew Membership</h3>
            <p>Process membership renewals.</p>
            <a href="queue.jsp" class="btn btn-warning">Renew</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS and dependencies (Optionl) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

