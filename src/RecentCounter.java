import java.util.*;

class RecentCounter {

    private Queue<Integer> integers;


    public RecentCounter() {
        integers = new LinkedList<>();
    }

    public int ping(int t) {

        integers.add(t);


        int i = t - 3000;


        while (integers.size()>0 && integers.peek()<i){
            integers.poll();
        }


        return integers.size();

    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();

        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(1000));
        System.out.println(recentCounter.ping(3000));
        System.out.println(recentCounter.ping(3002));
        System.out.println(recentCounter.ping(3010));
    }
}
