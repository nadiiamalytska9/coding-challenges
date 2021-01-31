package challenges.solution;

public class NewYearChaos {
    static int minimumBribes(int[] q) {
        int count = 0 ;

        int midThree = Integer.MAX_VALUE;
        int maxThree =  Integer.MAX_VALUE;
        int minThree =  Integer.MAX_VALUE ;

        for(int i=q.length-1 ; i >= 0 ; i--){
            if((q[i]-i) > 3 ) {
                System.out.println("Too chaotic");
            }
            else{
                if(q[i] > maxThree){
                    System.out.println("Too chaotic");
                }
                else if(q[i] > midThree){
                    count=count+2;
                }
                else if(q[i] > minThree){
                    count=count+1;
                }

                if(q[i]<minThree){
                    maxThree=midThree;
                    midThree=minThree;
                    minThree = q[i];
                }
                else if(q[i]<midThree){
                    maxThree=midThree;
                    midThree = q[i];
                }
                else if(q[i]<maxThree){
                    maxThree = q[i];
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
