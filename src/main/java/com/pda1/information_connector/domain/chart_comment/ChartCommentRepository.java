package com.pda1.information_connector.domain.chart_comment;

import com.pda1.information_connector.domain.statement_comment.StatementComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartCommentRepository extends JpaRepository<ChartComment,Long> {
}
