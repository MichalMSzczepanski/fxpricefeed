package work.szczepanskimichal.fxpricefeed.csvParser;

import org.springframework.stereotype.Component;
import work.szczepanskimichal.fxpricefeed.model.FX;
import work.szczepanskimichal.fxpricefeed.model.Price;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVParser {

//    this parser would communicate with the messaging broker to fetch market prices

    public List<Price> parseCSVToPrices() {
//todo        there's an issue how to manage the size of the required list of prices - based on the time of the transaction
        List<Price> prices = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] rawPrice = line.split(",");
                extractLineToPrice(prices, rawPrice);
            }
        } catch (FileNotFoundException e) {
//            exception would not happen in production - messaging queue would handle this
            throw new RuntimeException(e);
        } catch (IOException e) {
//            exception would not happen in production - messaging queue would handle this
            throw new RuntimeException(e);
        }
        return prices;
    }

    private void extractLineToPrice(List<Price> prices, String[] rawPrice) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SSS");
        LocalDateTime dateTime = LocalDateTime.parse(rawPrice[4], formatter);
        prices.add(Price.builder()
                .id(Integer.parseInt(rawPrice[0]))
                .name(FX.fromString(rawPrice[1].trim()))
                .bid(new BigDecimal(rawPrice[2].trim()))
                .ask(new BigDecimal(rawPrice[3].trim()))
                .timestamp(dateTime)
                .build());
    }
}
