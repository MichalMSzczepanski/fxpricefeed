package work.szczepanskimichal.fxpricefeed.model;

public enum FX {
    EUR_USD("EUR/USD"),
    GBP_USD("GBP/USD"),
    EUR_JPY("EUR/JPY");

    private final String name;

    FX(String name) {
        this.name = name;
    }

    public static FX fromString(String fxString) {
        for (FX fx : FX.values()) {
            if (fx.name.contentEquals(fxString)) {
                return fx;
            }
        }
//todo        preferably create exception handler
        throw new IllegalArgumentException("No constant for string: " + fxString);
    }
}
