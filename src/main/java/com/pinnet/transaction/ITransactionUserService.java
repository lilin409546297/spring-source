package com.pinnet.transaction;

public interface ITransactionUserService {

    void save(TransactionUser transactionUser);
    TransactionUser getTransactionUser(Long id);
}
