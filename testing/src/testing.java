public class testing {
    public static int odds(int n){
        if(n<1){
            return 0;
        }
        else{
            int i=1;
            int product=1;
            for(i=1; i<n+1; i++){
                product*=Math.max(1, (i%2)*i);
            }
            return product;
        }
    }

    public static void main(String[] args){
        int answer = odds(10);
        System.out.println("Answer is "+answer);
    }
}
