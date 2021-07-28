import tester.*;

import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;


class PointCompare implements Comparator<Point> {
    public int compare (Point firstPoint, Point secondPoint) {
        if (firstPoint.y < secondPoint.y) {
            return -1;
        }
        else if (firstPoint.y > secondPoint.y) {
            return 1;
        }

        if (firstPoint.x < secondPoint.x) {
            return -1;
        }
        else if (firstPoint.x >  secondPoint.x) {
            return 1;
        }

        return 0;
    }
}

class PointDistanceCompare implements Comparator<Point> {
    Point origin = new Point(0, 0);

    public int compare (Point firstPoint, Point secondPoint) {
        double firstDistance = firstPoint.distance(origin);
        double secondDistance = secondPoint.distance(origin);

        if (firstDistance < secondDistance) {
            return -1;
        }
        else if (firstDistance > secondDistance) {
            return 1;
        }

        return 0;
    }
}

class StringCompare implements Comparator<String> {
    public int compare (String firstString, String secondString) {
        return firstString.compareToIgnoreCase(secondString);
    }
}

class StringLengthCompare implements Comparator<String> {
    public int compare (String firstString, String secondString) {
        int firstLength = firstString.length();
        int secondLength = secondString.length();

        if (firstLength < secondLength) {
            return -1;
        }
        else if (firstLength > secondLength) {
            return 1;
        }

        return 0;
    }
}

class BooleanCompare implements Comparator<Boolean> {
    public int compare (Boolean firstBool, Boolean secondBool) {
        if (!firstBool && secondBool) {
            return -1;
        }
        else if (firstBool && !secondBool) {
            return 1;
        }

        return 0;
    }
}

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}

class CompareLists {
    public <T> T minimum (List<T> list, Comparator<T> comparator) {
        if (list.size() == 0) {
            return null;
        }

        T min = list.get(0);

        for (T element : list) {
            if (comparator.compare(min, element) > 0) {
                min = element;
            }
        }

        return min;
    }

    public <T> T minimum (T[] arr, Comparator<T> comparator) {
        if (arr.length == 0) {
            return null;
        }

        T min = arr[0];

        for (T element : arr) {
            if (comparator.compare(min, element) > 0) {
                min = element;
            }
        }

        return min;
    }

    public <T> List<T> greaterThan (List<T> list, Comparator<T> comparator, T minValue) {
        List<T> returnList = new ArrayList<>();

        for (T element : list) {
            if (comparator.compare(element, minValue) > 0) {
                returnList.add(element);
            }
        }

        return returnList;
    }

    public <T> boolean inOrder (List<T> list, Comparator<T> comparator) throws IllegalArgumentException {
        if (list.contains(null)) {
            throw new IllegalArgumentException("null value in list");
        }

        if (list.size() < 2) {
            return true;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            T element = list.get(i);

            if (comparator.compare(element, list.get(i + 1)) > 0) {
                return false;
            }
        }

        return true;
    }

    public <T> boolean inOrder (T[] arr, Comparator<T> comparator) throws IllegalArgumentException {
        if (arr.length == 0) {
            return true;
        }

        if (arr[0] == null) {
            throw new IllegalArgumentException("null value in array");
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] == null) {
                throw new IllegalArgumentException("null value in array");
            }

            if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

    public <T> List<T> merge (Comparator<T> comparator, List<T> firstList, List<T> secondList) throws IllegalArgumentException {
        if (firstList.contains(null)) {
            throw new IllegalArgumentException("null value in first list");
        }

        if (secondList.contains(null)) {
            throw new IllegalArgumentException("null value in second list");
        }

        List<T> sortedList = new ArrayList<>();
        int firstLength = firstList.size();
        int secondLength = secondList.size();
        int firstCount = 0;
        int secondCount = 0;

        while (firstCount < firstLength && secondCount < secondLength) {
            if (comparator.compare(firstList.get(firstCount), secondList.get(secondCount)) < 0) {
                sortedList.add(firstList.get(firstCount));
                firstCount++;
            }
            else {
                sortedList.add(secondList.get(secondCount));
                secondCount++;
            }
        }

        if (firstCount == firstLength) {
            for (int i = secondCount; i < secondLength; i++) {
                sortedList.add(secondList.get(i));
            }
        }

        else if (secondCount == secondLength){
            for (int i = firstCount; i < firstLength; i++) {
                sortedList.add(firstList.get(i));
            }
        }

        return sortedList;
    }


    Comparator<Point> pointComparator = new PointCompare();
    Point point1 = new Point(3, 4);
    Point point2 = new Point(0, 0);
    Point point3 = new Point(-3, 4);
    Point point4 = new Point(22, 22);


    public boolean testPointCompare (Tester t) {
        return t.checkExpect(pointComparator.compare(point1, point1), 0) &&
                t.checkExpect(pointComparator.compare(point1, point2), 1) &&
                t.checkExpect(pointComparator.compare(point1, point3), 1) &&
                t.checkExpect(pointComparator.compare(point1, point4), -1) &&
                t.checkExpect(pointComparator.compare(point2, point3), -1) &&
                t.checkExpect(pointComparator.compare(point2, point4), -1) &&
                t.checkExpect(pointComparator.compare(point4, point3), 1);
    }

    Comparator<Point> pointDistanceComparator = new PointDistanceCompare();
    Point point5 = new Point(0, 5);

    public boolean testPointDistanceCompare (Tester t) {
        return t.checkExpect(pointDistanceComparator.compare(point1, point1), 0) &&
                t.checkExpect(pointDistanceComparator.compare(point1, point2), 1) &&
                t.checkExpect(pointDistanceComparator.compare(point1, point3), 0) &&
                t.checkExpect(pointDistanceComparator.compare(point1, point4), -1) &&
                t.checkExpect(pointDistanceComparator.compare(point1, point5), 0);
    }

    Comparator<String> stringCompareTo = new StringCompare();
    String string1 = "";
    String string2 = "Aardvarks";
    String string3 = "Xylophone";
    String string4 = "Aaron A. Aaronson";

    public boolean testStringCompare (Tester t) {
        return t.checkExpect(stringCompareTo.compare(string1, string1), 0) &&
                t.checkExpect(stringCompareTo.compare(string1, string2), -9) &&
                t.checkExpect(stringCompareTo.compare(string1, string3), -9) &&
                t.checkExpect(stringCompareTo.compare(string2, string3), -23) &&
                t.checkExpect(stringCompareTo.compare(string2, string4), -11) &&
                t.checkExpect(stringCompareTo.compare(string3, string4), 23);
    }

    Comparator<String> stringCompareLength = new StringLengthCompare();

    public boolean testStringLengthCompare (Tester t) {
        return t.checkExpect(stringCompareLength.compare(string1, string1), 0) &&
                t.checkExpect(stringCompareLength.compare(string1, string2), -1) &&
                t.checkExpect(stringCompareLength.compare(string1, string4), -1) &&
                t.checkExpect(stringCompareLength.compare(string2, string3), 0) &&
                t.checkExpect(stringCompareLength.compare(string2, string4), -1) &&
                t.checkExpect(stringCompareLength.compare(string4, string1), 1) &&
                t.checkExpect(stringCompareLength.compare(string4, string3), 1);
    }

    Comparator<Boolean> boolCompare = new BooleanCompare();
    Boolean bool1 = true;
    Boolean bool2 = false;

    public boolean testBoolCompare (Tester t) {
        return t.checkExpect(boolCompare.compare(bool1, bool1), 0) &&
                t.checkExpect(boolCompare.compare(bool1, bool2), 1) &&
                t.checkExpect(boolCompare.compare(bool2, bool1), -1) &&
                t.checkExpect(boolCompare.compare(bool2, bool2), 0);
    }

    Point point6 = new Point(3, -4);
    List<String> stringList1 = new ArrayList<>(List.of("length","greater","less","contains","starts","end", "not"));
    List<String> stringList2 = new ArrayList<>();
    List<Point> pointList1 = new ArrayList<>(List.of(point1, point2, point3, point4, point5, point6));

    public boolean testMinimumList (Tester t) {
        return t.checkExpect(minimum(stringList1, stringCompareLength), "end") &&
                t.checkExpect(minimum(stringList1, stringCompareTo), "contains") &&
                t.checkExpect(minimum(stringList2, stringCompareLength), null) &&
                t.checkExpect(minimum(pointList1, pointComparator), point6) &&
                t.checkExpect(minimum(pointList1, pointDistanceComparator), point2);
    }

    String[] stringArr1 = new String[]{"The quick", "brown", "fox", "jumped over the", "lazy", "dog"};
    String[] stringArr2 = new String[0];

    Point point7 = new Point(-43, 54);
    Point point8 = new Point(321, 654);
    Point point9 = new Point(2, 655);
    Point point10 = new Point(12,-254);

    Point[] pointArr = new Point[]{point7, point8, point9, point10};

    public boolean testMinimumArr (Tester t) {
        return t.checkExpect(minimum(stringArr1, stringCompareLength), "fox") &&
                t.checkExpect(minimum(stringArr1, stringCompareTo), "brown") &&
                t.checkExpect(minimum(stringArr2, stringCompareLength), null) &&
                t.checkExpect(minimum(pointArr, pointComparator), point10) &&
                t.checkExpect(minimum(pointArr, pointDistanceComparator), point7);
    }

    List<Boolean> boolList = new ArrayList<>(List.of(false, false, true, true, false, true));

    public boolean testGreaterThan (Tester t) {
        return t.checkExpect(greaterThan(boolList, boolCompare, false), new ArrayList<>(List.of(true, true, true))) &&
                t.checkExpect(greaterThan(boolList, boolCompare, true), new ArrayList<>(List.of())) &&
                t.checkExpect(greaterThan(stringList1, stringCompareLength, "false"), new ArrayList<>(List.of("length","greater", "contains","starts"))) &&
                t.checkExpect(greaterThan(pointList1, pointComparator, new Point(0, 4)), new ArrayList<>(List.of(point1, point4, point5)));
    }

    List<Point> pointList2 = new ArrayList<>(List.of(point10, point7, point8, point9));
    List<Point> mergedPointList = new ArrayList<>(List.of(point10, point2, point3, point1, point5, point4, point7, point8, point9));
    List<String> nullStringList = Arrays.asList("this", "has", null, "a", "null");

    public boolean testInOrderList (Tester t) {
        try {
            return t.checkExpect(inOrder(stringList1, stringCompareTo), false) &&
                    t.checkExpect(inOrder(pointList1, pointComparator), false) &&
                    t.checkExpect(inOrder(pointList2, pointComparator), true) &&
                    t.checkExpect(inOrder(mergedPointList, pointComparator), true) &&
                    t.checkException(new IllegalArgumentException("null value in list"), this, "inOrder", nullStringList, stringCompareTo);
        }

        catch (Exception ignored) {}

        return false;
    }

    Point[] nullPointArr1 = new Point[]{null, new Point(1, 2), new Point(3, 4), new Point(4, 5)};
    Point[] nullPointArr2 = new Point[]{new Point(1, 2), new Point(3, 4), new Point(4, 5), null};
    Point[] nullPointArr3 = new Point[]{null};
    Point[] nullPointArr4 = new Point[]{new Point(1, 2), new Point(3, 4), null, new Point(4, 5)};

    public boolean testInOrderArr (Tester t) {
        try {
            return t.checkExpect(inOrder(stringArr1, stringCompareTo), false) &&
                    t.checkExpect(inOrder(pointArr, pointComparator), false) &&
                    t.checkExpect(inOrder(new Boolean[]{false, false, true}, boolCompare), true) &&
                    t.checkException(new IllegalArgumentException("null value in array"), this, "inOrder", nullPointArr1, pointComparator) &&
                    t.checkException(new IllegalArgumentException("null value in array"), this, "inOrder", nullPointArr2, pointComparator) &&
                    t.checkException(new IllegalArgumentException("null value in array"), this, "inOrder", nullPointArr3, pointComparator) &&
                    t.checkException(new IllegalArgumentException("null value in array"), this, "inOrder", nullPointArr4, pointComparator);
        }

        catch (Exception ignored) {}

        return false;
    }

    List<String> stringList3 = new ArrayList<>(List.of("a", "car", "effect"));
    List<String> stringList4 = new ArrayList<>(List.of("ba", "door", "fire truck"));
    List<Point> pointList3 = new ArrayList<>(List.of(point2, point3, point1, point5, point4));
    List<Point> nullPointList = Arrays.asList(nullPointArr2);

    public boolean testMerge (Tester t) {
        try {
            return t.checkExpect(merge(stringCompareLength, stringList3, stringList4), new ArrayList<>(List.of("a", "ba", "car", "door", "effect", "fire truck"))) &&
                    t.checkExpect(merge(stringCompareLength, stringList2, stringList4), new ArrayList<>(List.of("ba", "door", "fire truck"))) &&
                    t.checkExpect(merge(pointComparator, pointList2, pointList3), mergedPointList) &&
                    t.checkExpect(merge(stringCompareLength, stringList2, stringList2), stringList2) &&
                    t.checkExpect(merge(stringCompareTo, stringList3, stringList3), new ArrayList<>(List.of("a", "a", "car", "car", "effect", "effect"))) &&
                    t.checkException(new IllegalArgumentException("null value in first list"), this, "merge", stringCompareTo, nullStringList, stringList3) &&
                    t.checkException(new IllegalArgumentException("null value in second list"), this, "merge", pointComparator, pointList2, nullPointList);
        }

        catch (Exception ignored) {}

        return false;
    }
}