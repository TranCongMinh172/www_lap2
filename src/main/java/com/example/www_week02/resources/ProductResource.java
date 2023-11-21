package com.example.www_week02.resources;

import com.example.www_week02.models.Product;
import com.example.www_week02.services.ProductService;
import com.example.www_week02.services.impls.ProductImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/product")
public class ProductResource {
    private final ProductService productService;

    public ProductResource() {
            productService = new ProductImpl();
    }
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response insert(Product product) throws Exception {
        return productService.insert(product) ? Response.ok(product ).build():
                Response.status(Response.Status.BAD_REQUEST).build();
    }
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) throws Exception {
        Optional<Product> opt = productService.findById(id);
        return opt.isPresent() ? Response.ok(opt.get()).build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
//    @GET
//    @Produces("application/json")
//    public Response getAll() throws Exception {
//        return Response.ok(productService.getAll()).build();
//    }
@GET
@Produces("application/json")
public Response getAll() throws Exception {
    List<Product> products =productService.     getAll();
    return Response.ok(products).build();
}
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(Product product) throws Exception {
        return productService.update(product) ? Response.ok("Update successfully").build() :
                Response.status(Response.Status.BAD_REQUEST).build();
    }
}
