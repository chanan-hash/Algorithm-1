import java.util.Arrays;

/**
 * This classes is trying to implement the Stable-Marriage Algorithm of Gale-Shapley.
 * This is according to open-university course
 * https://courses.campus.gov.il/courses/course-v1:OUI+ACD_RFP4_Algorithm_HE+2022_1/courseware/a500288cec0348bdbcabd807367da7c4/65068c9a169c4dfe854634dc448ec90a/
 */

public class main {
    public static void main(String[] args) {
        int[][] manPref = new int[5][5];
//        7, 5, 6, 4},
//    {5, 4, 6, 7},
//    {4, 5, 6, 7},
//    {4, 5, 6, 7},
//    {0, 1, 2, 3},
//    {0, 1, 2, 3},
//    {0, 1, 2, 3},
//    {0, 1, 2, 3}};

        int[][] womanPref = {{2,3,1,5,4},
                             {5,2,1,4,3},
                            {3,4,2,1,5},
                            {4,2,5,3,1},
                            {2,5,4,1,3}
                                       };
        int[][] womenRank = new int[5][5];
        System.out.println(Arrays.deepToString(womanPref));
        translateToRank(womanPref,womenRank);
        System.out.println();
        System.out.println(Arrays.deepToString(womenRank));
    }

    // For accessing the men rank in the women setion, we need to translate it to comfortable workspace
    //    for(j=1 to k,i=1 to k)
    //      h=WomanPref[j,i]
    //      WomanRank[j,h]=i
    public static void translateToRank(int[][] womanPref, int[][] womenRank) {
        for (int i = 0; i <= womenRank.length; i++) {
            for (int j = 0; j <= womenRank[0].length; j++) {
                int h = womanPref[i][j];
                womenRank[i][h] = j; // hte h becoming 5, and there is no index of it
            }
        }
    }

    public static int[][] stableMarriage(int prefer[][]) {

        return null;
    }
}
