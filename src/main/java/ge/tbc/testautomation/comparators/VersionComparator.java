package ge.tbc.testautomation.comparators;

import java.util.Comparator;

public class VersionComparator implements Comparator<String> {
    @Override
    public int compare(String version1, String version2) {
        String firstParameterSubbedBeforeFirstDot = version1.substring(0, findFirstDotInVersion(version1) + 1);
        String secondParameterSubbedBeforeFirstDot = version2.substring(0, findFirstDotInVersion(version2) + 1);

        String firstParameterSubbedFromFirstDot = version1.substring(findFirstDotInVersion(version1), version1.length());
        String secondParameterSubbedFromFirstDot = version2.substring(findFirstDotInVersion(version2), version2.length());

        firstParameterSubbedFromFirstDot = firstParameterSubbedFromFirstDot.replaceAll("\\.", "");
        secondParameterSubbedFromFirstDot = secondParameterSubbedFromFirstDot.replaceAll("\\.", "");

        String readVersion1 = firstParameterSubbedBeforeFirstDot + firstParameterSubbedFromFirstDot;
        String readVersion2 = secondParameterSubbedBeforeFirstDot + secondParameterSubbedFromFirstDot;

        return Double.compare(Double.parseDouble(readVersion1), Double.parseDouble(readVersion2));
    }

    private int findFirstDotInVersion(String version){
        int result = 0;
        char[] characterArray = version.toCharArray();

        for (int i = 0; i < characterArray.length; i++){
            if (characterArray[i] == '.'){
                result = i;
                break;
            }
        }
        return result;
    }
}
