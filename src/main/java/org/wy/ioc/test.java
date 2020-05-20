package org.wy.ioc;

import org.wy.ioc.service.TransactionService;
import org.wy.ioc.service.TransactionServiceImpl;

public class test {
    public static void main(String[] args){
        TransactionService transactionService = new TransactionServiceImpl();
        transactionService.transaction();
    }
}
