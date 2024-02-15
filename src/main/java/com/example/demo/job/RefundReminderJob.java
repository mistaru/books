package com.example.demo.job;

import com.example.demo.entity.BookReserve;
import com.example.demo.service.BookReserveService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RefundReminderJob {

    BookReserveService service;

    @Scheduled(fixedDelay = 15000)
    void refundReminder() {
        System.out.println("Job сработал!");
        List<BookReserve> bookReserveList = service.findByAfterReturnDate();

        for (BookReserve br :bookReserveList) {
            System.out.println(br.getReader().getFirstname());
        }

    }
}
