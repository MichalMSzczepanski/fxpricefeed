package work.szczepanskimichal.fxpricefeed.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PriceDTO {
    private FX name;
    private BigDecimal bid;
    private BigDecimal ask;
}
