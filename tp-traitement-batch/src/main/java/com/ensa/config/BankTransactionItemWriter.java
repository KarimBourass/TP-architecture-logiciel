package com.ensa.config;

import com.ensa.BankTransactionRepository;
import com.ensa.dto.BankTransaction;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankTransactionItemWriter implements ItemWriter<BankTransaction> {

    @Autowired
    private BankTransactionRepository banktRepository;

    @Override
    public void write(List<? extends BankTransaction> list) throws Exception {
        banktRepository.saveAll(list);
    }
}
