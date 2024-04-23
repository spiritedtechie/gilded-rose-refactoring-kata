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

            Integer daysLeft = item.sellIn - 1;
            Integer increment = calculateQualityIncrement(item, daysLeft);
            incrementQuality(item, increment);
            item.sellIn = daysLeft;
        }
    }

    private Integer calculateQualityIncrement(Item item, Integer daysLeft) {
        if (item.name.equals(AGED_BRIE)) {
            return daysLeft < 0 ? 2 : 1;
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            if (daysLeft < 0) {
                return -item.quality;
            } else if (item.sellIn <= 5) {
                return 3;
            } else if (item.sellIn <= 10) {
                return 2;
            } else {
                return 1;
            }
        } else {
            return daysLeft < 0 ? -2 : -1;
        }
    }
}
