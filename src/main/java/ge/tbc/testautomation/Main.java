package ge.tbc.testautomation;

import ge.tbc.testautomation.comparators.CircleComparator;
import ge.tbc.testautomation.comparators.VersionComparator;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.*;

public class Main {
    @SomeAnnotation()
    int someIntegerElement = 12;

    @SomeAnnotation(name = "SomeStringElement")
    String someStringElement = "something";

    @SuppressWarnings({"rawtypes", "unchecked", "MismatchedQueryAndUpdateOfCollection"})
    public static void main(String[] args) {
//        deprecated
        API.oldFunction();

//        supresswarnings
        List lst = new ArrayList<>();
        lst.add(2);
        lst.add("2");

//        accessing ge.tbc.testautomation.annotations and other things (Reflection ge.tbc.testautomation.API)
        Field[] fields = Main.class.getDeclaredFields();

        for (Field field :
                fields) {
            System.out.println(field.getName());
            SomeAnnotation[] annotations = field.getAnnotationsByType(SomeAnnotation.class);
            for (SomeAnnotation annotation :
                    annotations) {
                System.out.println(annotation.name());
            }
        }

        Circle[] circles = new Circle[]{new Circle(12),
        new Circle(1), new Circle(23)};

        Arrays.sort(circles);
        System.out.println(Arrays.toString(circles));

        List<Circle> circleList = new ArrayList<>();
        circleList.add(new Circle(103));
        circleList.add(new Circle(11));
        circleList.add(new Circle(8));
        circleList.add(new Circle(256));


//        comparable
//        Collections.sort(circleList);

//        comparator
        circleList.sort(new CircleComparator());
        System.out.println(circleList);

//        0.14.5, 0.9, 0.13, 1.0, 1.2
        List<String> versions = new ArrayList<>();
        versions.add("0.14.5");
        versions.add("0.9");
        versions.add("0.13");
        versions.add("0.0.1.2.1");
        versions.add("1.0");
        versions.sort(new VersionComparator());

        System.out.println(versions);
    }

    @Test
    public void testVersionComparator(){
        String version1 = "0.13";
        String version2 = "0.0.12.1";

        String firstParameterSubbedBeforeFirstDot = version1.substring(0, findFirstDotInVersion(version1) + 1);
        String secondParameterSubbedBeforeFirstDot = version2.substring(0, findFirstDotInVersion(version2) + 1);

        String firstParameterSubbedFromFirstDot = version1.substring(findFirstDotInVersion(version1), version1.length());
        String secondParameterSubbedFromFirstDot = version2.substring(findFirstDotInVersion(version2), version2.length());

        firstParameterSubbedFromFirstDot = firstParameterSubbedFromFirstDot.replaceAll("\\.", "");
        secondParameterSubbedFromFirstDot = secondParameterSubbedFromFirstDot.replaceAll("\\.", "");

        String readVersion1 = firstParameterSubbedBeforeFirstDot + firstParameterSubbedFromFirstDot;
        String readVersion2 = secondParameterSubbedBeforeFirstDot + secondParameterSubbedFromFirstDot;

        System.out.println(readVersion1);
        System.out.println(readVersion2);

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
