package com.UVG.EjercicioAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.UVG.EjercicioAPI.Model.TicketModel;
import com.UVG.EjercicioAPI.Repository.TicketRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/incidents")
    public TicketModel addTicket(@RequestBody TicketModel newTicket) {
        return ticketRepository.save(newTicket);
    }

    @GetMapping("/incidents")
    public List<TicketModel> showTickets() {
        return ticketRepository.findAll();
    }

    @GetMapping("/incidents/{id}")
    public ResponseEntity<TicketModel> specificTicket(@PathVariable int id) {
        Optional<TicketModel> ticket = ticketRepository.findById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/incidents/{id}")
    public ResponseEntity<TicketModel> updateTicketStatus(@PathVariable int id, @RequestBody String newStatus) {
        Optional<TicketModel> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()) {
            TicketModel ticket = ticketOptional.get();
            ticket.setStatus(newStatus);
            ticketRepository.save(ticket);
            return ResponseEntity.ok(ticket);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/incidents/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable int id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
