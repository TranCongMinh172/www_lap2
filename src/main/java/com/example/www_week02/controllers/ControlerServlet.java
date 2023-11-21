package com.example.www_week02.controllers;

import com.example.www_week02.enums.ProductStatus;
import com.example.www_week02.models.Product;
import com.example.www_week02.services.ProductPriceService;
import com.example.www_week02.services.ProductService;
import com.example.www_week02.services.impls.ProductImpl;
import com.example.www_week02.services.impls.ProductPriceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ControlerServlet")
public class ControlerServlet extends HttpServlet {
    private  final ProductPriceService productPriceService = new ProductPriceImpl();
    private  final ProductService productService = new ProductImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "insertProduct":{
                try {
                    String name = req.getParameter("name");
                    String description = req.getParameter("description");
                    String unit = req.getParameter("unit");
                    String manufacturer  = req.getParameter("manufacturer");
                    String status  = req.getParameter("status");
                    double price  = Double.parseDouble(req.getParameter("price"));
                    Product product = new Product();
                    product.setName(name);
                    product.setDescription(description);
                    product.setUnit(unit);
                    product.setManufacturer(manufacturer);
                    product.setStatus(ProductStatus.valueOf(status));
                    productService.insert(product);
                    productPriceService.updatePrice(product.getProduct_id(),price);
                    resp.sendRedirect("products.jsp");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case "updateProduct":{
                try {
                    Long id = Long.parseLong(req.getParameter("ProductID"));
                    System.out.println(id);
                    String name = req.getParameter("name");
                    String description = req.getParameter("description");
                    String unit = req.getParameter("unit");
                    String manufacturer  = req.getParameter("manufacturer");
                    String status  = req.getParameter("status");
                    double price  = Double.parseDouble(req.getParameter("price"));
                    Product product = new Product();
                    product.setProduct_id(id);
                    product.setName(name);
                    product.setDescription(description);
                    product.setUnit(unit);
                    product.setManufacturer(manufacturer);
                    product.setStatus(ProductStatus.valueOf(status));
                    productService.update(product);
                    productPriceService.updatePrice(product.getProduct_id(),price);
                    resp.sendRedirect("products.jsp");
                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                    throw new RuntimeException("Error while processing the request: " + e.getMessage(), e);
                    e.printStackTrace();

                }
                break;
            }
            case "deleteProduct":{
                Long id = Long.parseLong(req.getParameter("id"));
                System.out.println(id);
                try {
                    productService.delete(id);
                    resp.sendRedirect("products.jsp");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case"addToCart":{

            }
        }
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        switch (action){
//            case "insertProduct":{
//                try {
//                    String name = req.getParameter("name");
//                    String description = req.getParameter("description");
//                    String unit = req.getParameter("unit");
//                    String manufacturer  = req.getParameter("manufacturer");
//                    String status  = req.getParameter("status");
//                    double price  = Double.parseDouble(req.getParameter("price"));
//                    Product product = new Product();
//                    product.setName(name);
//                    product.setDescription(description);
//                    product.setUnit(unit);
//                    product.setManufacturer(manufacturer);
//                    product.setStatus(ProductStatus.valueOf(status));
//                    productService.insert(product);
//                    productPriceService.updatePrice(product.getProduct_id(),price);
//                    resp.sendRedirect("products.jsp");
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//                break;
//            }
//            case "updateProduct":{
//                try {
//                    Long id = Long.parseLong(req.getParameter("id"));
//                    System.out.println(id);
//                    String name = req.getParameter("name");
//                    String description = req.getParameter("description");
//                    String unit = req.getParameter("unit");
//                    String manufacturer  = req.getParameter("manufacturer");
//                    String status  = req.getParameter("status");
//                    double price  = Double.parseDouble(req.getParameter("price"));
//                    System.out.println(price);
//                    Product product = new Product();
//                    product.setProduct_id(id);
//                    product.setName(name);
//                    product.setDescription(description);
//                    product.setUnit(unit);
//                    product.setManufacturer(manufacturer);
//                    product.setStatus(ProductStatus.valueOf(status));
//                    productService.update(product);
//                    productPriceService.updatePrice(product.getProduct_id(),price);
//                    resp.sendRedirect("products.jsp");
//                } catch (Exception e) {
////                    throw new RuntimeException(e);
////                    throw new RuntimeException("Error while processing the request: " + e.getMessage(), e);
//                    e.printStackTrace();
//
//                }
//                break;
//            }
//        }
//    }
}
