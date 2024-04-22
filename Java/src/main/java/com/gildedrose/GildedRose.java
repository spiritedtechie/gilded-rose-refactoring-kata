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
            if (items[i].name.equals(AGED_BRIE)
                    || items[i].name.equals(BACKSTAGE_PASSES)) {

                Item item = items[i];
                if (item.quality < 50) {
                    item.quality += 1;
                }
                if (item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.quality < 50 && item.sellIn < 11) {
                        item.quality += 1;
                    }

                    if (item.quality < 50 && item.sellIn < 6) {
                        item.quality += 1;
                    }
                }

            } else {
                if (items[i].quality > 0 && !items[i].name.equals(SULFURAS)) {
                    items[i].quality -= 1;
                }
            }

            if (!items[i].name.equals(SULFURAS)) {
                items[i].sellIn = items[i].sellIn - 1;
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
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
