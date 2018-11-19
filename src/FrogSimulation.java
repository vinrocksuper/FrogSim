public class FrogSimulation {
    private static int goalDistance;
    private static int maxHops;

    public  FrogSimulation(int dist,int numHops)
    {
        goalDistance = dist;
        maxHops = numHops;
    }
    public static int hopDistance()
    {

        if(Math.random() < .49)
        {
              return (int)(Math.random()*-32);
        }

        return (int)(Math.random()*32);
    }
    public static boolean simulate()
    {
        int hopCount = 0;
        int currentPos = goalDistance;
        System.out.println("Distance remaining: " + currentPos);
        while(hopCount<maxHops)
        {
            currentPos -= hopDistance();
            System.out.println("Distance remaining: "+ currentPos);
            if(currentPos <= 0)
            {
                System.out.println("Success: Final Distance: "+(goalDistance  + goalDistance-currentPos ));
                return true;
            }
            if(currentPos>goalDistance)
            {

                System.out.println("Failed: Negative position ");
                System.out.println();
                return false;
            }
            hopCount++;
        }

        System.out.println("Failed: Final Distance: " + (goalDistance-currentPos));
        System.out.println();
        return false;
    }
    public double runSimulation(int nums)
    {
        int count =0;
        for(int i=0;i<nums;i++)
        {

            boolean test = simulate();
            if(test)
            {
                count++;

                System.out.println();
            }
        }
        double val = (double)count/nums;
        return val;
    }

}
