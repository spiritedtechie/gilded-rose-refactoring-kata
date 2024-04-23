package com.gildedrose;

import static com.gildedrose.ItemType.SULFURAS;
import static com.gildedrose.ItemType.getItemType;

import java.util.Arrays;

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
        return Arrays.stream(values())
                .filter(s -> s.getItemName().equals(itemName))
                .findFirst()
                .orElse(NORMAL_ITEM);
    }
}

class GildedRose {
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (getItemType(item.name) == SULFURAS) {
            return;
        }

        Integer daysLeft = item.sellIn - 1;
        Integer increment = calculateQualityIncrement(item, daysLeft);
        incrementQuality(item, increment);
        item.sellIn = daysLeft;
    }

    private static Integer calculateQualityIncrement(Item item, Integer daysLeft) {
        switch (getItemType(item.name)) {
            case AGED_BRIE:
                return daysLeft < 0 ? 2 : 1;
            case BACKSTAGE_PASSES:
                if (daysLeft < 0) {
                    return -item.quality;
                } else if (item.sellIn <= 5) {
                    return 3;
                } else if (item.sellIn <= 10) {
                    return 2;
                } else {
                    return 1;
                }
            default:
                return daysLeft < 0 ? -2 : -1;
        }
    }

    private static void incrementQuality(Item item, Integer amount) {
        int newQuality = item.quality + amount;
        item.quality = Math.max(MIN_QUALITY, Math.min(MAX_QUALITY, newQuality));
    }
}
