package epamInterview.javacodingchallange;

public class LargestElement {

    public static int findLargestElement(int[] arr){

        if (arr==null||arr.length==0){
            throw new IllegalArgumentException("Array does not have any Element");
        }
        int max=arr[0];
        for (int i=1;i< arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] number={10,7,92,101,1000,323,2,3,54};
        int largest=findLargestElement(number);
        System.out.println("Largest Element of all: "+largest);
    }
}