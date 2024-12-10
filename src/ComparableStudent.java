import java.util.Arrays;

class ComparableStudent implements Comparable<ComparableStudent> {
    int iDNumber;
    String name;

    public ComparableStudent(int iDNumber, String name) {
        this.iDNumber = iDNumber;
        this.name = name;
    }

    @Override
    public int compareTo(ComparableStudent other) {
        // Сравнение по iDNumber
        return Integer.compare(this.iDNumber, other.iDNumber);
    }

    @Override
    public String toString() {
        return "ComparableStudent{" +
                "iDNumber=" + iDNumber +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ComparableStudent[] students = {
                new ComparableStudent(3, "Alice"),
                new ComparableStudent(1, "Bob"),
                new ComparableStudent(2, "Charlie")
        };

        // Сортировка массива
        Arrays.sort(students);
        System.out.println("Sorted by iDNumber: " + Arrays.toString(students));
    }
}