package com.pda1.information_connector.domain.chart_table;

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
public class ChartTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chartTableId;

    @Column
    private String annualHigh;
    private String annualLow;
    private String stockMarket;
    private String capital;
    private String listedStockNumber;
    private String marketCapital;
    private String per;
    private String eps;

    @OneToOne
    @JoinColumn(name = "stock_id")
    private StockInformation stockInformation;

    public ChartTable(String stockMarket, String annualHigh, String annualLow, String numberOfStock, String totalAmount, String per) {
        this.stockMarket = stockMarket;
        this.annualHigh = annualHigh;
        this.annualLow = annualLow;
        this.listedStockNumber = numberOfStock;
        this.marketCapital = totalAmount;
        this.per = per;

        this.eps = "";
        this.capital = Long.toString((Long.parseLong(totalAmount)*2));
    }
}
