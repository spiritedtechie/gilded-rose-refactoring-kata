package com.gildedrose;

class GildedRose {
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final String AGED_BRIE = "Aged Brie";

    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];

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
            } else if (!item.name.equals(SULFURAS)) {
                item.decrementQuality();
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn = item.sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals(AGED_BRIE)) {
                    if (!items[i].name.equals(BACKSTAGE_PASSES)) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals(SULFURAS)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    item.incrementQuality();
                }
            }
        }
    }
}
