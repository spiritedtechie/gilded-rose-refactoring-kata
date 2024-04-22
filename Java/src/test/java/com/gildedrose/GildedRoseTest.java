package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void test_sellInMoreThanZero_agedBrie_quality49_incrementsQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 49) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_sellInMoreThanZero_agedBrie_quality50_qualityRemainsUnchanged() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_sellInMoreThanZero_backstagePasses_quality50_qualityRemainsUnchanged() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_sellInMoreThanZero_backstagePasses_quality47_sellIn10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 47) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(49, app.items[0].quality);
    }

    @Test
    void test_sellInMoreThanZero_backstagePasses_quality47_sellIn5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 47) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_sellInMoreThanZero_backstagePasses_quality49_sellIn10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_sellInMoreThanZero_backstagePasses_quality48_sellIn5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_sellInMoreThanZero_backstagePasses_quality49_sellIn11() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 49) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_sellInMoreThanZero_backstagePasses_quality47_sellIn11() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 47) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(48, app.items[0].quality);
    }

    @Test
    void test_sellInMoreThanZero_cheddarCheese_quality1_decrements() {
        Item[] items = new Item[] { new Item("Cheddar cheese", 11, 1) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void test_sellInMoreThanZero_cheddarCheese_quality0_qualityRemainsUnchanged() {
        Item[] items = new Item[] { new Item("Cheddar cheese", 11, 0) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    void test_sellInMoreThanZero_sulfuras_quality1_qualityRemainsUnchanged() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 11, 1) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(1, app.items[0].quality);
    }

    @Test
    void test_sellInMoreThanZero_sulfuras_quality0_qualityRemainsUnchanged() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 11, 0) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test 
    void test_sulfuras_sellInNotDecremented() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 11, 0) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(11, app.items[0].sellIn);
    }

    @Test 
    void test_agedBrie_sellInIsDecremented() {
        Item[] items = new Item[] { new Item("Aged Brie", 11, 0) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(10, app.items[0].sellIn);
    }
}
