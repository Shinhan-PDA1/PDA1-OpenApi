package com.pda1.information_connector.domain.statement_comment;

import com.pda1.information_connector.domain.stock_info.StockInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatementCommentRepository extends JpaRepository<StatementComment,Long> {
    Optional<StatementComment> findByStockInformation(StockInformation stockInformation);
}
