package com.casino.rank.controller;

import com.casino.rank.deletate.CasinoDeligate;
import com.casino.rank.model.request.TransactionRequest;
import com.casino.rank.model.request.UpdateBalanceRequest;
import com.casino.rank.model.response.GetBalanceResponse;
import com.casino.rank.model.response.TransactionsResponse;
import com.casino.rank.model.response.UpdateBalanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("casino")
public class CasinoController {


    @Autowired
    private CasinoDeligate casinoDeligate;

    public CasinoController(CasinoDeligate casinoDeligate) {
        this.casinoDeligate = casinoDeligate;
    }

    @RequestMapping(value = "player/{playerId}/balance",method = RequestMethod.GET)
    public ResponseEntity<GetBalanceResponse> getBalance(@PathVariable int playerId) {
        try {
            return new ResponseEntity<>(this.casinoDeligate.getPlayerBalance(playerId), HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "player/{playerId}/balance/update",method = RequestMethod.PUT)
    public ResponseEntity<UpdateBalanceResponse> updateBalance(@PathVariable int playerId, @RequestBody UpdateBalanceRequest request) {
        try {
            return new ResponseEntity<>(this.casinoDeligate.updatePlayerBalance(playerId, request), HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (RuntimeException e) {
            return  new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "admin/player/transactions",method = RequestMethod.POST)
    public ResponseEntity<List<TransactionsResponse>> transactions(@RequestBody TransactionRequest request) {
        try {
            return new ResponseEntity<>(this.casinoDeligate.lastTenTransactions(request), HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
