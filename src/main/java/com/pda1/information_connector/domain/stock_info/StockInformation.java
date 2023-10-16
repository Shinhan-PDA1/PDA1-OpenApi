package com.pda1.information_connector.domain.stock_info;

import com.pda1.information_connector.domain.BaseTimeEntity;
import com.pda1.information_connector.domain.chart_comment.ChartComment;
import com.pda1.information_connector.domain.chart_table.ChartTable;
import com.pda1.information_connector.domain.statement.Statement;
import com.pda1.information_connector.domain.statement_comment.StatementComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class StockInformation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    @Column
    private String stockCode;
    private String stockName;

    @OneToMany(mappedBy = "stockInformation", orphanRemoval = true)
    private List<Statement> statments = new ArrayList<>();

    public StockInformation(String korSecnNm, String shotnIsin) {
        this.stockName = korSecnNm;
        this.stockCode = shotnIsin;
    }
}
