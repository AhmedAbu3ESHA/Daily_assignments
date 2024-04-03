package org.example;

import jakarta.ws.rs.*;

@Path("/store")
@Consumes("application/json")
@Produces("application/json")
public class StoreResourse {
    StoreResourse obj=new StoreResourse();
    @put
    @Path("/{type}/{num}")
    public int add(@PathParam("type") String type,@PathParam("num") int num) {
        obj.add(type, num);
        return 1;
    }

}
