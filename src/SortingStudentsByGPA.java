import java.util.Arrays;
import java.util.Comparator;

class SortingStudentsByGPA implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        // Сортировка по итоговым баллам (предполагается, что они в поле iDNumber)
        return Integer.compare(s2.iDNumber, s1.iDNumber); // Обратный порядок
    }

    public static void quickSort(Student[] students, int low, int high) {
        if (low < high) {
            int pi = partition(students, low, high);

            quickSort(students, low, pi - 1);
            quickSort(students, pi + 1, high);
        }
    }

    private static int partition(Student[] students, int low, int high) {
        Student pivot = students[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (students[j].iDNumber >= pivot.iDNumber) { // По убыванию
                i++;
                // Swap
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }

        Student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(85, "Alice"),
                new Student(95, "Bob"),
                new Student(70, "Charlie"),
                new Student(90, "David")
        };

        System.out.println("Before sorting: " + Arrays.toString(students));
        quickSort(students, 0, students.length - 1);
        System.out.println("After sorting by GPA (descending): " + Arrays.toString(students));
    }
}