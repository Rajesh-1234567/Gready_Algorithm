import java.util.*;
public class activitySelection {
    public static int activitySelectionWhenSortedEndIsNotGiven(int start[],int end[]){
        int [][]table= new int[start.length][3];
        for(int i=0;i<start.length;i++){
            table[i][0]=i;
            table[i][1]=start[i];
            table[i][2]= end[i];
        }
        
    //Lambda function ->shortest (It sort the matrix according to column number given)
        Arrays.sort(table, Comparator.comparingDouble(o->o[2]));
        int countMyAct=1,lastEnd=table[0][2];
        ArrayList<Integer> ans= new ArrayList<>();
        ans.add(table[0][0]);
        for(int i=0;i<start.length;i++){
            if(table[i][1]>=lastEnd) {
            countMyAct++;
            ans.add(table[i][0]);
            lastEnd= table[i][2];
            }
        }
        return countMyAct;
    }
    
    public static int activitySelectionWhenSortedEndGiven(int start[],int end[]){
        int countMyAct=1,lastEnd=end[0];
        ArrayList<Integer> ans= new ArrayList<>();
        for(int i=0;i<start.length;i++){
            if(start[i]>=lastEnd) {
            countMyAct++;
            ans.add(i);
            lastEnd= end[i];
            }
        }
        return countMyAct;
    }
    
    public static void main(String []args){
        int []start={1,3,0,5,8,5};
        int []end={2,4,6,7,9,9};
        int ans=activitySelectionWhenSortedEndGiven(start,end);
        System.out.println(ans);
        ans=activitySelectionWhenSortedEndIsNotGiven(start,end);
        System.out.println(ans);
    }
}

