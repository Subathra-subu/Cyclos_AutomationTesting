package com.Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtility {

<<<<<<< HEAD
    public static List<String> getStatusData(String filePath) {
=======
<<<<<<< HEAD
    public static List<String> getVoucherCodes(String filePath) {

        List<String> voucherCodes =
                new ArrayList<>();
=======
	public static List<String> getVoucherCodes(String filePath) {
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

<<<<<<< HEAD
        List<String> statuses = new ArrayList<>();
=======
		List<String> voucherCodes = new ArrayList<>();
>>>>>>> 3763e922d7bc4f5935daf9f118dd907d7cf6fb74
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

        try {

<<<<<<< HEAD
            BufferedReader br =
                    new BufferedReader(new FileReader(filePath));
=======
<<<<<<< HEAD
            BufferedReader br =
                    new BufferedReader(
                            new FileReader(filePath));
=======
			BufferedReader br = new BufferedReader(new FileReader(filePath));
>>>>>>> 3763e922d7bc4f5935daf9f118dd907d7cf6fb74
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

            br.readLine();

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

<<<<<<< HEAD
                statuses.add(data[0].trim());
            }
=======
<<<<<<< HEAD
                voucherCodes.add(data[0].trim());
            }
=======
				voucherCodes.add(data[0].trim());
			}
>>>>>>> 3763e922d7bc4f5935daf9f118dd907d7cf6fb74
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

            br.close();

<<<<<<< HEAD
        }
=======
<<<<<<< HEAD
        } catch (Exception e) {

            e.printStackTrace();
        }

        return voucherCodes;
    }
=======
		} catch (Exception e) {
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

        catch (Exception e) {

<<<<<<< HEAD
            e.printStackTrace();
        }

        return statuses;
    }
=======
		return voucherCodes;
	}
>>>>>>> 3763e922d7bc4f5935daf9f118dd907d7cf6fb74
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
}