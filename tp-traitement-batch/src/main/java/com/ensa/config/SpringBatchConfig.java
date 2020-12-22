package com.ensa.config;

import com.ensa.dto.BankTransaction;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.Date;


@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private ItemReader<BankTransaction> itemReader;
    @Autowired
    private ItemWriter<BankTransaction> itemWriter;
    @Autowired
    private ItemProcessor<BankTransaction,BankTransaction> bankProcessor;


    @Bean
    public Job bankJob(){
        Step step1=stepBuilderFactory.get("step-laod-data")
        .<BankTransaction,BankTransaction>chunk(100)
        .reader(itemReader)
        .processor(bankProcessor)
        .writer(itemWriter)
        .build();

        return jobBuilderFactory.get("bank-loader-job")
                .start(step1)
                .build();

    }

    @Bean
    public FlatFileItemReader<BankTransaction> flatFileItemReader(@Value("${transactionData}") Resource transactionData){
        FlatFileItemReader<BankTransaction> fileItemReader = new FlatFileItemReader<>();
        fileItemReader.setName("Reader1");
        fileItemReader.setLinesToSkip(1);
        fileItemReader.setResource(transactionData);
        fileItemReader.setLineMapper(lineMapper());

        return fileItemReader;
    }

    public LineMapper<BankTransaction> lineMapper() {
        DefaultLineMapper<BankTransaction> lineMapper=new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id","idCompte","montant","strDateTransaction");
        lineMapper.setLineTokenizer(lineTokenizer);
        BeanWrapperFieldSetMapper fieldSetMapper= new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(BankTransaction.class);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }



}
