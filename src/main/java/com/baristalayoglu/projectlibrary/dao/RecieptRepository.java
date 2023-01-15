package com.baristalayoglu.projectlibrary.dao;

import com.baristalayoglu.projectlibrary.entity.Reciept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecieptRepository extends JpaRepository<Reciept, Long> {
}
