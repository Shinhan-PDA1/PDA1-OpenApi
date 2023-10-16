package com.pda1.information_connector.domain.statement;

import com.pda1.information_connector.domain.stock_info.StockInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatementRepository extends JpaRepository<Statement, Long> {
    Optional<Statement> findByStockInformation(StockInformation stockInformation);
}
