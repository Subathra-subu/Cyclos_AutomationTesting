package com.Utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtility {

<<<<<<< HEAD
<<<<<<< HEAD
    public static List<String> getStatusData(String filePath) {
=======
<<<<<<< HEAD
    public static List<String> getVoucherCodes(String filePath) {

        List<String> voucherCodes =
                new ArrayList<>();
=======
=======
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
	public static List<String> getVoucherCodes(String filePath) {
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

<<<<<<< HEAD
        List<String> statuses = new ArrayList<>();
=======
		List<String> voucherCodes = new ArrayList<>();
<<<<<<< HEAD
>>>>>>> 3763e922d7bc4f5935daf9f118dd907d7cf6fb74
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
=======
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

<<<<<<< HEAD
        try {
=======
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

<<<<<<< HEAD
<<<<<<< HEAD
            BufferedReader br =
                    new BufferedReader(new FileReader(filePath));
=======
<<<<<<< HEAD
            BufferedReader br =
                    new BufferedReader(
                            new FileReader(filePath));
=======
=======


        try {


>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
			BufferedReader br = new BufferedReader(new FileReader(filePath));
<<<<<<< HEAD
>>>>>>> 3763e922d7bc4f5935daf9f118dd907d7cf6fb74
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
=======
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

<<<<<<< HEAD
            br.readLine();
=======
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

<<<<<<< HEAD
            String line;
=======
            // Skip header row
            br.readLine();
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

<<<<<<< HEAD
            while ((line = br.readLine()) != null) {
=======
            String line;
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

<<<<<<< HEAD
                String[] data = line.split(",");
=======
            while ((line = br.readLine()) != null) {
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

<<<<<<< HEAD
<<<<<<< HEAD
                statuses.add(data[0].trim());
            }
=======
<<<<<<< HEAD
                voucherCodes.add(data[0].trim());
            }
=======
=======
                String[] data = line.split(",");

>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
				voucherCodes.add(data[0].trim());
			}
<<<<<<< HEAD
>>>>>>> 3763e922d7bc4f5935daf9f118dd907d7cf6fb74
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
=======
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

<<<<<<< HEAD
            br.close();
=======
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

<<<<<<< HEAD
<<<<<<< HEAD
        }
=======
<<<<<<< HEAD
        } catch (Exception e) {
=======


            br.close();

		} catch (Exception e) {
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git

            e.printStackTrace();
        }

<<<<<<< HEAD
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
=======
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
		return voucherCodes;
	}
<<<<<<< HEAD
>>>>>>> 3763e922d7bc4f5935daf9f118dd907d7cf6fb74
>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
=======




>>>>>>> branch 'main' of https://github.com/Subathra-subu/Cyclos_AutomationTesting.git
}