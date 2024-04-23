package com.gildedrose;

class GildedRose {
    private static final int MIN_QUALITY = 0;

    private static final int MAX_QUALITY = 50;

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static final String AGED_BRIE = "Aged Brie";

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private static void incrementQuality(Item item, Integer amount) {
        int newQuality = item.quality + amount;
        item.quality = Math.max(MIN_QUALITY, Math.min(MAX_QUALITY, newQuality));
    }

    public void updateQuality() {
        for (Item item : this.items) {
            if (item.name.equals(SULFURAS)) {
                continue;
            }

            Integer sellInAtStartOfDay = item.sellIn;
            Integer sellInAtEndOfDay = item.sellIn - 1;
            item.sellIn = sellInAtEndOfDay;

            if (item.name.equals(AGED_BRIE)) {
                incrementQuality(item, 1);
                if (sellInAtEndOfDay < 0) {
                    incrementQuality(item, 1);
                }
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                incrementQuality(item, 1);
                if (sellInAtStartOfDay <= 10) {
                    incrementQuality(item, 1);
                }
                if (sellInAtStartOfDay <= 5) {
                    incrementQuality(item, 1);
                }
                if (sellInAtEndOfDay < 0) {
                    item.quality = 0;
                }
            } else {
                incrementQuality(item, -1);
                if (sellInAtEndOfDay < 0) {
                    incrementQuality(item, -1);
                }
            }

        }
    }
}
