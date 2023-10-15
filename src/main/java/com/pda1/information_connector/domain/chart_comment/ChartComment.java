package com.pda1.information_connector.domain.chart_comment;

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
public class ChartComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chartCommentId;

    @Column(columnDefinition = "LONGTEXT")
    private String comment;

    @OneToOne
    @JoinColumn(name = "stock_id")
    private StockInformation stockInformation;
}
