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

            Integer closingSellIn = item.sellIn - 1;

            Integer increment;
            if (item.name.equals(AGED_BRIE)) {
                increment = closingSellIn < 0 ? 2 : 1;
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                if (closingSellIn < 0) {
                    increment = -item.quality;
                } else if (item.sellIn <= 5) {
                    increment = 3;
                } else if (item.sellIn <= 10) {
                    increment = 2;
                } else {
                    increment = 1;
                }
            } else {
                increment = closingSellIn < 0 ? -2 : -1;
            }

            incrementQuality(item, increment);
            item.sellIn = closingSellIn;
        }
    }
}
