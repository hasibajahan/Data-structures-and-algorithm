//problem statement:
//Koko loves bananas. There are several piles of bananas in front of her, and each pile contains a certain number of bananas. 
//Koko can decide a fixed eating speed k (bananas per hour). Each hour, she can choose any one pile and eat k bananas from it.
//if the pile has fewer than k bananas, she eats the whole pile and doesn't continue to another pile in that hour.
//She must finish eating all the bananas in H hours or less.
//your task is to find the minimum integer eating speed k such that Koko can eat all the bananas within H hours.

//time complexity: O(nlogm) where n is the number of piles and m is the maximum number of bananas in a pile.For each possible speed (log m), we check all piles (n).

//space complexity: O(1)

//code
import java.util.*;

class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed=1;//as koko can eat minimum 1 banana/hr
        int maxSpeed=0;
        for(int pile:piles){
            maxSpeed=Math.max(maxSpeed,pile);
        }

        //perform binary search in the range minSpeed to maxSpeed
        while(minSpeed<maxSpeed){
            int mid=minSpeed+(maxSpeed-minSpeed)/2;
            if(canEat(piles,h,mid)){
                //it means koko has more time remaining so koko can decrease the speed,i.e. we can check for lesser speed
                maxSpeed=mid;//discard the right side
            }else
            {
                //increase the eating speed
                minSpeed=mid+1;
            }
        }
        //now i need the minimum speed of eating so return it
        return minSpeed;
    }

    private boolean canEat(int[] piles,int h,int speed){
        //in this helper method i will just check that the total hours taken to eat all the bananas are less or greater than the given hours
        int hours=0;
        for(int pile:piles){
            hours+=(int)Math.ceil((double)pile/speed);//we are taking ceil value because koko cannot move to the next pile even if there are time remaining after eating the current pile entirely
        }
        return hours<=h;
    }

    //main method
    public static void main(String[] args) {
        KokoEatingBanana koko=new KokoEatingBanana();
        int[] piles={3, 6, 7, 11};
        int h=8;
        int result=koko.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result); 
    }
}

// Output: Minimum eating speed: 4
    