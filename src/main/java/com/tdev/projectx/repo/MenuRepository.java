package com.tdev.projectx.repo;

import com.tdev.projectx.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}