        <%@ page import="com.example.www_week02.models.Product" %>
<%@ page import="com.example.www_week02.enums.ProductStatus" %>
<%@ page import="com.example.www_week02.services.ProductService" %>
<%@ page import="com.example.www_week02.services.impls.ProductImpl" %>
<%@ page import="java.util.Optional" %>
        <%@ page import="com.example.www_week02.services.ProductPriceService" %>
        <%@ page import="com.example.www_week02.services.impls.ProductPriceImpl" %>
        <%@ page import="com.example.www_week02.models.ProductPrice" %>
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
<%
    ProductService productService = new ProductImpl();
    ProductPriceService productPriceService = new ProductPriceImpl();
    Long id = Long.valueOf(request.getParameter("id"));
    Optional<Product> optionalProduct;
    Product product;
    ProductPrice productPrice;
    try {
        optionalProduct = productService.findById(id);
        product = optionalProduct.orElseThrow();
        Optional<ProductPrice> productPriceOptional = productPriceService.findByProductId(id);
        productPrice = productPriceOptional.orElseThrow();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
%>
<div class="container mt-5">
    <h2>Update Product</h2>
    <form action="ControlerServlet?action=updateProduct" method="post">

        <div class="form-group">
            <label for="ProductID">ProductID:</label>
            <input type="text" class="form-control" id="ProductID" name="ProductID" value="<%=product.getProduct_id()%>" readonly  required>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="<%=product.getName()%>"  required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea class="form-control" id="description" name="description"  required><%=product.getDescription()%></textarea>
        </div>
        <div class="form-group">
            <label for="unit">Unit:</label>
            <input type="text" class="form-control" id="unit" name="unit" value="<%=product.getUnit()%>" required>
        </div>
        <div class="form-group">
            <label for="manufacturer">Manufacturer:</label>
            <input type="text" class="form-control" id="manufacturer" name="manufacturer" value="<%=product.getManufacturer()%>" required>
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="text" class="form-control" id="price" name="price" value="<%=productPrice.getPrice()%>" required>
        </div>
        <div class="form-group">
            <label for="status">Status:</label>
            <select class="form-control"   id="status" name="status" required>
                <option value="ACTIVE" <%= product.getStatus() == ProductStatus.ACTIVE ? "selected" : "" %>>ACTIVE</option>
                <option value="IN_ACTIVE" <%= product.getStatus() == ProductStatus.IN_ACTIVE ? "selected" : "" %>>IN_ACTIVE</option>
                <option value="TERMINATED" <%= product.getStatus() == ProductStatus.TERMINATED ? "selected" : "" %>>TERMINATED</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update Product</button>
    </form>
</div>

<!-- Link to Bootstrap JS and Popper.js (for Bootstrap features) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
