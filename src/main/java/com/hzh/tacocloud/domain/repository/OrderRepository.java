package com.hzh.tacocloud.domain.repository;

import com.hzh.tacocloud.domain.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
}
