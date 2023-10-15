package com.pda1.information_connector.domain.stock_info;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StockInformationRepository extends JpaRepository<StockInformation, Long> {
    //Optional<StockInformation> findByStockCode(String code);
}
