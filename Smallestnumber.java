package smallestnumber;

/**
 *
 * @author Rupesh Kumar
 */
public class Smallestnumber {

    /**
     * @param args the command line arguments
     */
    private static void smallest(int A[])
    {
        int i;
        for(i = A.length-1;i>0;i--)
        {
            if(A[i] < A[i-1])
            {
                break;
            }    
        }    
        if(i == 0)
        {
            System.out.println("smallest number cannot be formed from the digits");
            return;
        }    
        int j;
        for(j = 1;j<A.length;j++)
        {
            if(A[j] > A[i])
            {
                break;
            }    
        }
        int t = A[j];
        A[j] = A[i];
        A[i] = t;
        int k;
        if((A.length-1)> i){
        boolean flag = false;    
        for(k = A.length-1;k>i;k--)
        {
            if(A[k] < A[k-1])
            {
                flag = true;
                break;
            }    
        } 
        if(flag){
        t = A[k];
        A[k] = A[k-1];
        A[k-1] = t;
        } 
        }  
        System.out.println("Second smallest number");
        for(k=0;k<A.length;k++)
        {
            System.out.print(A[k]+" ");
        }    
        System.out.println();
    }        
    
    public static void main(String[] args) {
        // TODO code application logic here
        int A[] = {1,3,2,3};
        smallest(A);
    
    }
    
}
