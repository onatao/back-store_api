package dev.natao.projectweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.natao.projectweb.entities.OrderItem;

@Repository
public interface OrdemItemRepository extends JpaRepository<OrderItem, Long>{

}
