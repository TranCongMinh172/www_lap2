<%@ page import="com.example.www_week02.models.Product" %>
<%@ page import="com.example.www_week02.enums.ProductStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Insert Product</title>
  <!-- Link to Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
  <h2>Insert Product</h2>
  <form action="ControlerServlet?action=insertProduct" method="post">
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="form-group">
      <label for="description">Description:</label>
      <textarea class="form-control" id="description" name="description" required></textarea>
    </div>
    <div class="form-group">
      <label for="unit">Unit:</label>
      <input type="text" class="form-control" id="unit" name="unit" required>
    </div>
    <div class="form-group">
      <label for="manufacturer">Manufacturer:</label>
      <input type="text" class="form-control" id="manufacturer" name="manufacturer" required>
    </div>
    <div class="form-group">
      <label for="price">Price:</label>
      <input type="text" class="form-control" id="price" name="price" required>
    </div>
    <div class="form-group">
      <label for="status">Status:</label>
      <select class="form-control"   id="status" name="status" required>
        <option value="ACTIVE">ACTIVE</option>
        <option value="IN_ACTIVE">IN_ACTIVE</option>
        <option value="TERMINATED">TERMINATED</option>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Insert Product</button>
  </form>
</div>

<!-- Link to Bootstrap JS and Popper.js (for Bootstrap features) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
