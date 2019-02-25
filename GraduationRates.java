import java.util.Random;
public class GraduationRates {
    public static void main(String [] args) {
        Random rnd = new Random();
        Students [] class2011 = new Students[20];
        Students [] class2012 = new Students[20];
        Students [] class2013 = new Students[20];
        int grad2011 = 0;
        int grad2012 = 0;
        int grad2013 = 0;
        int studentsPicked = rnd.nextInt(10)+16;
        HashMap graduationOf2017 = new HashMap();

        // initialize arrays
        for (int i = 0; i < 20; i++) {
            class2011[i] = new Students(2011);
            class2012[i] = new Students(2012);
            class2013[i] = new Students(2013);
        }

        System.out.println(studentsPicked + " graduates in 2017!");
        // pick students from different arrays and put them in the hashtable
        for (int i = 0; i < studentsPicked; i++) {
            int classArrayPick = rnd.nextInt(3); // picks arrays
            int studentPick = rnd.nextInt(20); // picks index in arrays
            if (classArrayPick == 0) {
                graduationOf2017.put(class2011[studentPick]);
                grad2011++;
            }
            else if (classArrayPick == 1) {
                graduationOf2017.put(class2012[studentPick]);
                grad2012++;
            }
            else {
                graduationOf2017.put(class2013[studentPick]);
                grad2013++;
            }
        }

        System.out.println("Graduation rate for 2011: " + (double)grad2011/60.0);
        System.out.println("Graduation rate for 2012: " + (double)grad2012/40.0);
        System.out.println("Graduation rate for 2013: " + (double)grad2013/20.0);
    }
}
