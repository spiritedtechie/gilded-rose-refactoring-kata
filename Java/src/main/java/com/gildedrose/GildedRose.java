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

            if (item.name.equals(AGED_BRIE)) {
                item.incrementQuality();
            } else if (item.name.equals(BACKSTAGE_PASSES)) {
                item.incrementQuality();
                if (item.sellIn < 11) {
                    item.incrementQuality();
                }
                if (item.sellIn < 6) {
                    item.incrementQuality();
                }
                
            } else {
                item.decrementQuality();
                
            }

            item.sellIn -= 1;

            if (item.sellIn < 0) {
                if (item.name.equals(AGED_BRIE)) {
                    item.incrementQuality();
                } else if (item.name.equals(BACKSTAGE_PASSES)) {
                    item.quality = 0;
                } else {
                    item.decrementQuality();
                }
            }
        }
    }
}
