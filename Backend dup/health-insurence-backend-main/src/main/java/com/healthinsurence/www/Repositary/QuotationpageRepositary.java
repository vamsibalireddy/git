package com.healthinsurence.www.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthinsurence.www.Entity.Quotationpage;

@Repository
public interface QuotationpageRepositary extends JpaRepository<Quotationpage, String> {

}
