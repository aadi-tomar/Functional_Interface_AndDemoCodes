public class Data {

    int num;
    boolean setValue = false;

    public synchronized void getData() throws InterruptedException {

        while(!setValue){
            wait();
        }
        System.out.println("Get : " + num);
        setValue = false;
        notify();
    }

    public synchronized void setData( int num) throws InterruptedException {
        while(setValue){
            wait();
        }

        System.out.println("Put : " + num);
        this.num = num;
        setValue = true;
        notify();

    }


    public static void main(String[] args) {

        Data data = new Data();
        new Producer(data);
        new Consumer(data);
    }

}
