<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.www_week02.services.ProductService" %>
<%@ page import="com.example.www_week02.services.impls.ProductImpl" %>
<%@ page import="com.example.www_week02.models.Product" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.example.www_week02.services.ProductPriceService" %>
<%@ page import="com.example.www_week02.services.impls.ProductPriceImpl" %>
<%@ page import="com.example.www_week02.models.ProductPrice" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Product Details</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%
  Long productId = Long.valueOf(request.getParameter("id"));
  ProductService productService = new ProductImpl();
  Optional<Product> productOptional = productService.findById(productId);
  Product product = productOptional.orElseThrow();
  ProductPriceService productPriceService = new ProductPriceImpl();
  Optional<ProductPrice> productPriceOptional = productPriceService.findByProductId(productId);
  ProductPrice productPrice = productPriceOptional.orElseThrow();
%>
<div class="container mt-5">
  <h2>Product Details</h2>
  <table class="table table-striped table-bordered">
    <thead>
    <th scope="row">Product ID</th>
    <th scope="row">Product Name</th>
    <th scope="row">Product Price</th>
    </thead>
    <tbody>
    <tr>

      <td><%=product.getProduct_id()%></td>
      <td><%=product.getName()%></td>
      <td><%=productPrice.getPrice()%></td>
    </tr>

    </tbody>
  </table>
  <form action="AddToCartServlet" method="post">
    <input type="hidden" name="productId" value="<%=product.getProduct_id()%>">
    <input type="hidden" name="productName" value="<%=product.getName()%>">
    <input type="hidden" name="productPrice" value="<%=productPrice.getPrice()%>">
    <button type="submit" class="btn btn-primary">Pay</button>
  </form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
