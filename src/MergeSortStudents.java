import java.util.ArrayList;
import java.util.List;

public class MergeSortStudents {
    public static List<Student> mergeSort(List<Student> students) {
        if (students.size() <= 1) {
            return students;
        }

        int mid = students.size() / 2;
        List<Student> left = mergeSort(new ArrayList<>(students.subList(0, mid)));
        List<Student> right = mergeSort(new ArrayList<>(students.subList(mid, students.size())));

        return merge(left, right);
    }

    private static List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).iDNumber <= right.get(j).iDNumber) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i++));
        }

        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }

    public static void main(String[] args) {
        List<Student> list1 = List.of(new Student(1, "Alice"), new Student(4, "Bob"));
        List<Student> list2 = List.of(new Student(2, "Charlie"), new Student(3, "David"));

        List<Student> mergedList = mergeSort(new ArrayList<>() {{
            addAll(list1);
            addAll(list2);
        }});

        System.out.println("Merged and sorted list: " + mergedList);
    }
}