<%@ page import="com.example.www_week02.services.ProductService" %>
<%@ page import="com.example.www_week02.services.impls.ProductImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.www_week02.models.Product" %>
<%@ page import="com.example.www_week02.models.ProductPrice" %>
<%@ page import="com.example.www_week02.services.ProductPriceService" %>
<%@ page import="com.example.www_week02.services.impls.ProductPriceImpl" %>
<%@ page import="java.util.Optional" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Page</title>
    <!-- Link to Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%

    ProductService productService = new ProductImpl();
    List<Product> products = productService.getAllActiveProduct(2);


%>
<div class="container mt-5">
    <h2>Product List</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th scope="col">Product ID</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Price</th>
            <th scope="col">Unit</th>
            <th scope="col">Manufacturer</th>
            <th scope="col">Status</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Product product : products) {
                ProductPriceService productPriceService = new ProductPriceImpl();
                Optional<ProductPrice> productPriceOptional = null;
//                Long id = product.getProduct_id();
//                String delete = "ControlerServlet?action=deleteProduct&id="+id;
                try {
                    productPriceOptional = productPriceService.findByProductId(product.getProduct_id());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                ProductPrice productPrice = productPriceOptional.orElse(new ProductPrice());
        %>
        <tr>
            <td><%=product.getProduct_id()%></td>
            <td><%=product.getName()%></td>
            <td><%=product.getDescription()%></td>
            <td><%=productPrice.getPrice()%></td>
            <td><%=product.getUnit()%></td>
            <td><%=product.getManufacturer()%></td>
            <td><%=product.getStatus()%></td>
            <td>
                <!-- Nút Insert -->


                <!-- Nút Update -->
<%--                <a href="ControlerServlet?action=updateProduct&id=<%=product.getProduct_id()%>" class="btn btn-success">Update</a>--%>
                <a href="updateProduct.jsp?id=<%=product.getProduct_id()%>" class="btn btn-success">Update</a>



                <!-- Nút Delete -->
<%--                <a href=<%=delete%>  >delete</a>--%>
                <form action="ControlerServlet?action=deleteProduct" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%=product.getProduct_id()%>">
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>

                <!-- Nút Add to Cart -->
<%--                <form action="addToCart" method="post" style="display:inline;">--%>
<%--                    <input type="hidden" name="productId" value="<%=product.getProduct_id()%>">--%>
<%--                    <button type="submit" class="btn btn-info">Add to Cart</button>--%>
<%--                </form>--%>
                <a href="addToCart.jsp?id=<%=product.getProduct_id()%>" class="btn btn-info">Add to cart</a>
            </td>
        </tr>
        <% }
        %>
        </tbody>
    </table>
    <div class="mt-3">
        <a href="addProduct.jsp" class="btn btn-success">Insert</a>
    </div>
</div>

<!-- Link to Bootstrap JS and Popper.js (for Bootstrap features) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
