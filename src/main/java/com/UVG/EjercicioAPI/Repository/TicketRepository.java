package com.UVG.EjercicioAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.UVG.EjercicioAPI.Model.TicketModel;

@Repository
public interface TicketRepository extends JpaRepository<TicketModel, Integer> {
}
