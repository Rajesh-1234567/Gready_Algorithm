import java.util.*;
public class knapSack {
    public static void main(String []args){
     int []weight={10,20,30};
     int []value= {60,100,120};
     int capacity=50;
     int ans=0;
     double [][]table=new double[weight.length][2];  
     for(int i=0;i<weight.length;i++){
        table[i][0]=i;
        table[i][1]=value[i]/(double)weight[i];
     }
        Arrays.sort(table, Comparator.comparingDouble(o->o[1])); // nabla function
        for(int i=weight.length-1;i>=0;i--){
            int idx=(int) table[i][0];
            if(capacity >=weight[idx]){
                ans += value[idx];
                capacity -= weight[idx];
            }else{
                ans += ( table[i][1]*capacity); 
                capacity=0;break;
            }
        }
        System.out.println("The maxm value is : "+ ans);
     
    }
}
