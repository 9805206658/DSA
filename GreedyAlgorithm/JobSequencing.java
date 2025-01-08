import java.util.*;
public class JobSequencing
{
    public static class Job
    {
          int id;
          int deadline ;
          int profit;
        public Job(int id,int dl,int p)
        {   this.id = id;
            this.deadline = dl;
            this.profit = p;
        }
     }
   public static void main(String args[])
    {
        int jobsInfo[][]= {{4,20},{1,10},{1,40},{1,30}};
        //  creating the arraylist  for storing info jobs
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i =0; i<jobsInfo.length; i++)
        {  jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));}
        //  sorting jobs in descending order basic of the profit;
        Collections.sort(jobs,(a,b)->b.profit - a.profit);
        // storing sequence info;
        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(jobs.get(0).id);
        int time =1;
       for(int i = 0; i<jobs.size(); i++)
        { if(time < jobs.get(i).deadline)
            {
                 seq.add(jobs.get(i).id); 
                 time++;
           }
         }
         System.out.println("the total jobs are");
         for(int i =0; i<seq.size() ; i++)
         {
            System.out.println(seq.get(i));
         }
    }
}