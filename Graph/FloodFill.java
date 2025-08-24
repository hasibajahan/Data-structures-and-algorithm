//problem statement:
//You are given a 2D image represented by an integer grid. Each cell in the grid represents the color of a pixel. 
//Starting from a given pixel (sr, sc), you need to change the color of that pixel and all 4-directionally connected pixels of the same initial color to a new given color. 
//Return the modified image.

//code
public class FloodFill {
    
    //perform dfs on starting pixel and change color of the visited nodes
    private void dfs(int[][] copy,int[][] image, 
                int row, int col,
                int[]row_shift, int[] col_shift, int newColor, int initialColor)
        {
        copy[row][col]=newColor;
        int n=image.length;
        int m=image[0].length;
        
        for(int i=0;i<4;i++){
                int new_row=row+row_shift[i];
                int new_col=col+col_shift[i];
                //boundary checks
                if(new_row>=0 && new_row<n && new_col>=0  && new_col<m
                   && image[new_row][new_col]==initialColor && copy[new_row][new_col]!=newColor){
                       dfs(copy,image,new_row,new_col, row_shift, col_shift, newColor,initialColor);
                   }
            }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //copy the image
        int[][] copy=image;
        int initialColor=image[sr][sc];
        //row shift
        int[] row_shift={-1, 0, 1, 0};        
        //column shift
        int[] col_shift={0, 1, 0, -1};
        //call dfs
        dfs(copy,image,sr,sc, row_shift,col_shift, newColor,initialColor);
        return copy;
    }

//main method
public static void main(String[] args){
	FloodFill ff=new FloodFill();
	int[][] originalImage={{1,1,1},{1,1,0},{1,0,1}};
	int[][] result=ff.floodFill(originalImage,1,1,2);
	System.out.println("changed image: ");
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			System.out.print(result[i][j]+" ");
		}
		System.out.println();
	}

}
}

//output:
//C:\Users\Hasiba\Desktop\Data_structures_and_algorithm\Graph>javac FloodFill.java

//C:\Users\Hasiba\Desktop\Data_structures_and_algorithm\Graph>java FloodFill
//changed image:
//2 2 2
//2 2 0
//2 0 1