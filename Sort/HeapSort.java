package Sort;

import java.util.Arrays;

//Datastructure for min heap
class PriorityQueue{

        private static int[] A = null;
        private static int size = 0;

        //Constructor
        PriorityQueue(int[] arr){
            A = Arrays.copyOf(arr, arr.length);
            size = A.length;

            //Start from last internal node, all the way up to the root
            //last node = 2*i+2, i = (last node - 2)/2
            for(int i = (A.length - 2)/2; i>=0; i--){
                heapify(i);
            }
        }

        private static int LEFT(int i){
            return (2*i+1);
        }

        private static int RIGHT(int i){
            return (2*i+2);
        }

        private static void heapify(int i){
            int leftInd = LEFT(i);
            int rightInd = RIGHT(i);
            int smallest = i;

            if(leftInd<size && A[leftInd] < A[i]){
                smallest = leftInd;
            }

            if(rightInd<size && A[rightInd] < A[smallest]){
                smallest = rightInd;
            }

            if(smallest != i){
                //swap and recursively heapify to the smallest old position
                swap(i, smallest);
                heapify(smallest);
            }
        }

        private static void swap(int a, int b){
            int temp = A[a];
            A[a] = A[b];
            A[b] = temp;
        }

        public static boolean isEmpty(){
            if(size > 0){
                return false;
            }else {
                return true;
            }
        }

        public static int pop(){
            if(size < 1){
                return -1;
            }

            int top = A[0];

            //replace the root of the heap with the last element in the heap
            A[0] = A[size-1];

            size--;

            //heapify from the new root
            heapify(0);

            return top;

        }
}

class HeapSort{
    public static void main(String[] args){
        int[] A = {6, 4, 7, 1, 9, -2};
        HeapSort(A);
    }

    public static void HeapSort(int[] array){
        //Sort A (Not fully sorted)
        PriorityQueue pq = new PriorityQueue(array);


        int i=0;
        while (!pq.isEmpty()){
            array[i++] = pq.pop();
        }

        System.out.println(Arrays.toString(array));
    }
}