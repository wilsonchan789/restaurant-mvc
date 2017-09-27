package com.tandtseafoodedmonds.restaurantmvc.models.data;

import com.tandtseafoodedmonds.restaurantmvc.models.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class MenuItemImporter {

    private static final String DATA_FILE = "menu_item.csv";
    private static boolean isDataLoaded = false;

    /**
     * Read in data from a CSV file and store it in a list
     */
    static void loadData(MenuItem menuItem) {

        // Only load data once
        if (isDataLoaded) {
            return;
        }

        try {

            // Open the CSV file and set up pull out column header info and records
            Resource resource = new ClassPathResource(DATA_FILE);
            InputStream is = resource.getInputStream();
            Reader reader = new InputStreamReader(is);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            // Put the records into a more friendly format
            for (CSVRecord record : records) {

                String categoryStr = record.get("category");
                String priceStr = record.get("price");
                String spicyStr = record.get("spicy");
                String poundStr = record.get("pound");

                Category category = menuItem.getCategories().findByValue(categoryStr);
                if (category == null) {
                    category = new Category(categoryStr);
                    menuItem.getCategories().add(category);
                }

                Price price = menuItem.getPrices().findByValue(priceStr);
                if (price == null) {
                    price = new Price(priceStr);
                    menuItem.getPrices().add(price);
                }

                Spicy spicy= menuItem.getSpicys().findByValue(spicyStr);
                if (spicy == null) {
                    spicy = new Spicy(spicyStr);
                    menuItem.getSpicys().add(spicy);
                }

                Pound pound = menuItem.getPounds().findByValue(poundStr);
                if (pound == null) {
                    pound = new Pound(poundStr);
                    menuItem.getPounds().add(pound);
                }

                Menu newMenu = new Menu(record.get("name"), category, price, spicy, pound);

                menuItem.add(newMenu);
            }

            // flag the data as loaded, so we don't do it twice
            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load job data");
            e.printStackTrace();
        }
    }

}