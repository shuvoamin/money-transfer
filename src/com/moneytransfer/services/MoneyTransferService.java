package com.moneytransfer.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.moneytransfer.domain.AccountRepository;

@Path("/transfer")
public class MoneyTransferService {
	
	private AccountRepository accountRepository = new AccountRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{fromAccount}/{toAccount}/{amount}")
    public Response transfer(@PathParam("fromAccount") int fromAccount, @PathParam("toAccount") int toAccount, @PathParam("amount") Double amount) {
        
    	MoneyTransferResponse response = accountRepository.TransferMoney(fromAccount, toAccount, amount);
        
        return Response.ok(response).build();
    }

}
