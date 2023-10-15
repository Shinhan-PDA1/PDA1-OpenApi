package com.pda1.information_connector.domain.chart_comment;

import com.pda1.information_connector.domain.statement_comment.StatementComment;
import com.pda1.information_connector.domain.stock_info.StockInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChartCommentRepository extends JpaRepository<ChartComment,Long> {
    //Optional findByStockInfortmation(StockInformation stockInformation);
}
