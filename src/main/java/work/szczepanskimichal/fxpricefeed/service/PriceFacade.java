package work.szczepanskimichal.fxpricefeed.service;

import work.szczepanskimichal.fxpricefeed.model.PriceDTO;

import java.util.List;

public interface PriceFacade {
    List<PriceDTO> listMarketPrices();

}
