package com.project.mama.earth.repository;

import com.project.mama.earth.model.OrderedItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Repository
public interface OrderedItemsRepository extends JpaRepository<OrderedItems,Long> {
}
