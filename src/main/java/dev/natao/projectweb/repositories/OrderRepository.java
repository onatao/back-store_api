package dev.natao.projectweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.natao.projectweb.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
