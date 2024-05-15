class Renshu {

    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    //ここに続きを実装していく。
    public int sumUpToN(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
    public int sumFromPtoQ(int p, int q) {
        int sum=0;
        if(p>q)return -1;
        for(int i=p;i<=q;i++){
            sum+=i;
        }
        return sum;
    }
    public int sumFromArrayIndex(int[] a, int index) {
        if(a.length<=index)return -1;
        int sum=0;
        for(int i=index;i<a.length;i++){
            sum+=a[i];
        }
        return sum;
    }
    public int selectMaxValue(int[] a) {
        int max=a[0];
        for(int i=1;i<a.length;i++){
            if(max<a[i]){
                max=a[i];
            }
        }
        return max;
    }
    public int selectMinValue(int[] a) {
        int min=a[0];
        for(int i=1;i<a.length;i++){
            if(min>a[i]){
                min=a[i];
            }
        }
        return min;
    }
    public int selectMinIndex(int[] a) {
            int minIndex = 0;
            int minValue = a[0];
        
            for (int i = 1; i < a.length; i++) {
                if (a[i] < minValue) {
                    minValue = a[i];
                    minIndex = i;
                }
            }
            return minIndex;
    }
    public int selectMaxIndex(int[] a) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
        
            for (int i = 0; i < a.length; i++) {
                if (a[i] > max) {
                    max = a[i];
                    maxIndex = i;
                } else if (a[i] == max && i < maxIndex) {
                    maxIndex = i;
                }
            }
            return maxIndex;
                
    }
    public void swapArrayElements(int[] p, int i, int j) {
            if (p == null || i < 0 || i >= p.length || j < 0 || j >= p.length) {
                throw new IllegalArgumentException("不正な引数です。");
            }
        
            int temp = p[i];
            p[i] = p[j];
            p[j] = temp;
        
    }
    public boolean swapTwoArrays(int[] a, int[] b) {
            if (a == null || b == null || a.length != b.length) {
                return false;
            }
        
            for (int i = 0; i < a.length; i++) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            }
        
            return true;
    }
    public void bubbleSort(int[] array){
        int n = array.length;
        boolean m;
        for (int i = 0; i < n - 1; i++) {
            m = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    m = true;
                }
            }
            if (!m) break;
        }
    }
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        return i + 1;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public void quickSortShortTime() {
    }
    public void swapArrayElements() {
    }
}