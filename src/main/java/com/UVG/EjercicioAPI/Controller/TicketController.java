package com.UVG.EjercicioAPI.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UVG.EjercicioAPI.Model.TicketModel;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    List<TicketModel> ticketList = new ArrayList<>();

    @PostMapping("/incidents")
    public TicketModel addTicket(@RequestBody TicketModel newTicket) {
        ticketList.add(newTicket);
        return newTicket;
    }

    @GetMapping("/incidents")
    public List<TicketModel> showTickets() {
        return ticketList;
    }

    @GetMapping("/incidents/{id}")
    public TicketModel specificTicket(@PathVariable int id) {
        Optional<TicketModel> ticket = ticketList.stream().filter(t -> t.getId() == id).findFirst();
        return ticket.orElse(null);
    }

    @PutMapping("/incidents/{id}")
    public ResponseEntity<TicketModel> updateTicketStatus(@PathVariable int id, @RequestBody String newStatus) {
        Optional<TicketModel> ticket = ticketList.stream().filter(t -> t.getId() == id).findFirst();
        if (ticket.isPresent()) {
            ticket.get().setStatus(newStatus);
            return ResponseEntity.ok(ticket.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/incidents/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable int id) {
        boolean removed = ticketList.removeIf(ticket -> ticket.getId() == id);
        if (removed) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
