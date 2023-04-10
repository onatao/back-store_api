package dev.natao.projectweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.natao.projectweb.entities.OrderItem;
import dev.natao.projectweb.entities.pk.OrderItemPK;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
