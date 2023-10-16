package com.pda1.information_connector.domain.chart_table;

import com.pda1.information_connector.domain.stock_info.StockInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChartTableRepository extends JpaRepository<ChartTable, Long> {
    Optional<ChartTable> findByStockInformation(StockInformation stockInformation);
}
