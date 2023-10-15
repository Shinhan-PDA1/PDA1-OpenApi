package com.pda1.information_connector.domain.statement;

import com.pda1.information_connector.domain.BaseTimeEntity;
import com.pda1.information_connector.domain.stock_info.StockInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Statement extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statementId;

    @Column
    private String type;
    private String date;
    private String bps;
    private String eps;
    private String pbr;
    private String per;
    private String roe;
    private String netIncome;
    private String quickRatio;
    private String sales;
    private String dividendPayoutRatio;
    private String debtRatio;
    private String netProfitMargin;
    private String marketOdds;
    private String operationProfitMargin;
    private String retentionRate;
    private String dividendPerShare;

    @ManyToOne
    @JoinColumn(name="stock_id")
    private StockInformation stockInformation;
}
