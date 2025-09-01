//problem statement:
//You are given an array prices where prices[i] is the price of a stock on the i-th day.
//You have to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
//Return the maximum profit you can achieve from this transaction. If no profit can be made, return 0.

//time and space complexity:
//checking all the elements of the array once so the time complexity is O(n)
//using constant space so space complexity is O(1)

//code
// public class BuyAndSellStock{

//     public int maxProfit(int[] prices) {
//         //to get the maximum profit we have to buy at minimum price and sell at a maximum price.
//         int minPrice=prices[0];
//         int max_profit=0;
        
//         for(int i=1;i<prices.length;i++){
//             if(minPrice>prices[i])//selling price is less than buying price don't sell it, update the buying price instead
//             {
//                 minPrice=prices[i];
                
//             }else{
//                 //selling price is greater than buying price. It means I can sell the stock
//                 int profit=prices[i]-minPrice;
//                 max_profit=Math.max(max_profit,profit);
//             }
//         }
//         return max_profit;
//         }

        //sliding window approach:
public class BuyAndSellStock{

    public int maxProfit(int[] prices) {
        int left=0;//buying price
        int right=1;//selling price
        int max_profit=0;
        while(right<prices.length){
          if(prices[left]<prices[right])//sell
	        {
		        int profit=prices[right]-prices[left];
		        max_profit=Math.max(max_profit,profit);
		      }else{
			      left=right;//don't sell just update the buying price
		      }
		      right++;//check for better selling price
        }
	        return max_profit;
    }

        public static void main(String[] args) {
            BuyAndSellStock obj=new BuyAndSellStock();
            int[] prices={7,1,5,3,6,4};
            System.out.println("Maximum profit: "+obj.maxProfit(prices));
        }
    }

//output:
//Maximum profit: 5