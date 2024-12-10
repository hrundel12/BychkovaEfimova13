import java.util.Arrays;

class Student {
    int iDNumber;
    String name;

    public Student(int iDNumber, String name) {
        this.iDNumber = iDNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "iDNumber=" + iDNumber +
                ", name='" + name + '\'' +
                '}';
    }
}

public class TestStudentSorting {
    public static void insertionSort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student key = students[i];
            int j = i - 1;

            // Сортируем по iDNumber
            while (j >= 0 && students[j].iDNumber > key.iDNumber) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(3, "Alice"),
                new Student(1, "Bob"),
                new Student(2, "Charlie")
        };

        System.out.println("Before sorting: " + Arrays.toString(students));
        insertionSort(students);
        System.out.println("After sorting by iDNumber: " + Arrays.toString(students));
    }
}