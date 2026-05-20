package com.Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtility {

<<<<<<< HEAD
    public static List<String> getVoucherCodes(String filePath) {

        List<String> voucherCodes =
                new ArrayList<>();
=======
	public static List<String> getVoucherCodes(String filePath) {

		List<String> voucherCodes = new ArrayList<>();
>>>>>>> 3763e922d7bc4f5935daf9f118dd907d7cf6fb74

		try {

<<<<<<< HEAD
            BufferedReader br =
                    new BufferedReader(
                            new FileReader(filePath));
=======
			BufferedReader br = new BufferedReader(new FileReader(filePath));
>>>>>>> 3763e922d7bc4f5935daf9f118dd907d7cf6fb74

			br.readLine();

			String line;

			while ((line = br.readLine()) != null) {

				String[] data = line.split(",");

<<<<<<< HEAD
                voucherCodes.add(data[0].trim());
            }
=======
				voucherCodes.add(data[0].trim());
			}
>>>>>>> 3763e922d7bc4f5935daf9f118dd907d7cf6fb74

			br.close();

<<<<<<< HEAD
        } catch (Exception e) {

            e.printStackTrace();
        }

        return voucherCodes;
    }
=======
		} catch (Exception e) {

			e.printStackTrace();
		}

		return voucherCodes;
	}
>>>>>>> 3763e922d7bc4f5935daf9f118dd907d7cf6fb74
}