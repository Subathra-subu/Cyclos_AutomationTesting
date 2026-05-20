package com.Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtility {

    public static List<String> getStatusData(String filePath) {

        List<String> statuses = new ArrayList<>();

        try {

            BufferedReader br =
                    new BufferedReader(new FileReader(filePath));

            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                statuses.add(data[0].trim());
            }

            br.close();

        }

        catch (Exception e) {

            e.printStackTrace();
        }

        return statuses;
    }
}