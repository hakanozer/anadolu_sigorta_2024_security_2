<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
        <h2>Customer Login</h2>
        <c:if test="${errors != null}">
            <c:forEach items="${errors}" var="item">
                <div>${item.getField()} - ${item.getDefaultMessage()}</div>
            </c:forEach>
        </c:if>
        <h3><c:out value="${name}"></c:out></h3>
        <form action="login" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">Name</label>
                <input name="name" type="text" class="form-control" id="name">
            </div>
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Email address</label>
                <input required name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input required name="password" type="password" class="form-control" id="exampleInputPassword1">
            </div>
            <div class="mb-3">
            <select  name="type" class="form-select" aria-label="Default select example">
                <option value="user" selected>User</option>
                <option value="customer">Customer</option>
                <option value="admin">Admin</option>
            </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    <div class="col-sm-4"></div>
    </div>
</div>
</body>
</html>