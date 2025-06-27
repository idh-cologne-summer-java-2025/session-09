package SearchTrees;

import java.util.Comparator;

/**
 * Vergleicht Studierende nach Name
 */
public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int cmp = s1.getName().compareTo(s2.getName());
        if(cmp==0) {
        	cmp = Integer.compare(s1.getMatrikelNummer(), s2.getMatrikelNummer());
        }
        //TODO Hier sollte man vielleicht namensgleiche Studierende behandeln.
        return cmp;
    }
}
