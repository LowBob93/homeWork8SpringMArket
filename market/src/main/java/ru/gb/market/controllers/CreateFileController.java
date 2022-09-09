package ru.gb.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.market.services.CreateFileService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/web-socket")
public class CreateFileController {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final CreateFileService reportService;

    @MessageMapping("/createFile")
    @SendTo("/topic/createFile")
    public String getReport() {
        reportService.createReport();
        return "products.xlsx";
    }
}