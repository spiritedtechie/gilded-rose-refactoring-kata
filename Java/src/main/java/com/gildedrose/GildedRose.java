package com.gildedrose;

import static com.gildedrose.ItemType.AGED_BRIE;
import static com.gildedrose.ItemType.BACKSTAGE_PASSES;
import static com.gildedrose.ItemType.SULFURAS;
import static com.gildedrose.ItemType.getItemType;

enum ItemType {
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    NORMAL_ITEM("Normal Item");

    private final String itemName;

    ItemType(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public static ItemType getItemType(String itemName) {
        for (ItemType type : values()) {
            if (type.getItemName().equals(itemName)) {
                return type;
            }
        }
        return NORMAL_ITEM;
    }
}

class GildedRose {
    private static final int MIN_QUALITY = 0;

    private static final int MAX_QUALITY = 50;

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
            if (getItemType(item.name) == SULFURAS) {
                continue;
            }

            Integer daysLeft = item.sellIn - 1;
            Integer increment = calculateQualityIncrement(item, daysLeft);
            incrementQuality(item, increment);
            item.sellIn = daysLeft;
        }
    }

    private static Integer calculateQualityIncrement(Item item, Integer daysLeft) {
        ItemType itemType = ItemType.getItemType(item.name);
        if (itemType == AGED_BRIE) {
            return daysLeft < 0 ? 2 : 1;
        } else if (itemType == BACKSTAGE_PASSES) {
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
