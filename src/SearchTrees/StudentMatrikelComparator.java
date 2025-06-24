package SearchTrees;

import java.util.Comparator;

/**
 * Vergleicht Studierende nach Matrikelnummer (aufsteigend)
 */
public class StudentMatrikelComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getMatrikelNummer(), s2.getMatrikelNummer());
    }
}