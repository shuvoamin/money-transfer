package com.moneytransfer.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.moneytransfer.domain.AccountRepository;
import com.moneytransfer.services.AccountService;
import com.moneytransfer.services.MoneyTransferResponse;

@Path("/money-transfer")
public class MoneyTransferApi {
	
    private AccountService accountService = new AccountService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{fromAccount}/{toAccount}/{amount}")
    public Response transfer(
            @PathParam("fromAccount") int fromAccount,
            @PathParam("toAccount") int toAccount,
            @PathParam("amount") Double amount) {
        
        MoneyTransferResponse response = 
                accountService.TransferMoney(fromAccount, toAccount, amount);

        return Response.ok(response).build();
            
    }

}
