package com.funnyy.component.queue.queueapi.rest;

import com.funnyy.component.queue.queueapi.model.SendModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by sky on 17-5-17.
 */
@Path("/queue/redis")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface RedisQueueResource {

    @POST
    @Path("/send")
    boolean sendMessage(SendModel sendModel);

    @GET
    @Path("/get/{queueName}")
    String getMessage(@PathParam("queueName") String queueName);
}
