package com.moneytransfer.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.moneytransfer.services.AccountService;
import com.moneytransfer.services.IAccountService;
import com.moneytransfer.services.MoneyTransferResponse;

@Path("/money-transfer")
public class MoneyTransferApi {
    
    private final IAccountService _accountService;
    
    // ideally this will be injected as dependency via some IoC tool
    public MoneyTransferApi(){
        _accountService = new AccountService();
    }

    // TODO : handle exceptions
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{fromAccount}/{toAccount}/{amount}")
    public Response transfer(
            @PathParam("fromAccount") int fromAccount,
            @PathParam("toAccount") int toAccount,
            @PathParam("amount") Double amount) {
        
        MoneyTransferResponse response = 
                _accountService.TransferMoney(fromAccount, toAccount, amount);

        return Response.ok(response).build();
            
    }

}
