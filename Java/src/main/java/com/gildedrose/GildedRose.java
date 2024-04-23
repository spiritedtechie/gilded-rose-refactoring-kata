package com.gildedrose;

class GildedRose {
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public static final String AGED_BRIE = "Aged Brie";

    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
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
                item.incrementQuality();
                if (sellInAtEndOfDay < 0) {
                    item.incrementQuality();
                }
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                item.incrementQuality();
                if (sellInAtStartOfDay < 11) {
                    item.incrementQuality();
                }
                if (sellInAtStartOfDay < 6) {
                    item.incrementQuality();
                }
                if (sellInAtEndOfDay < 0) {
                    item.quality = 0;
                }
                
            } else {
                item.decrementQuality();
                if (sellInAtEndOfDay < 0) {
                    item.decrementQuality();
                }
                
            }
        }
    }
}
