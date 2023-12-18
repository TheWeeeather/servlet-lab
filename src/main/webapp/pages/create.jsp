<%--
  Created by IntelliJ IDEA.
  User: sn0ri
  Date: 30.10.2023
  Time: 02:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Create</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<div class="container">
    <div class="row justify-content-center">
        <form class="mt-5 w-25" action="/create" method="post">

            <div class="form-floating mb-3">
                <input type="text" name="name" class="form-control" id="name" placeholder="name@example.com">
                <label for="name">Name</label>
            </div>

            <div class="form-floating mb-3">
                <input type="date" name="birthday" class="form-control" id="birthday" placeholder="name2@example.com">
                <label for="birthday">Birthday Date</label>
            </div>


            <div class="d-grid gap-2 col-6 mx-auto">
                <button class="btn btn-dark" type="submit">Save</button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
