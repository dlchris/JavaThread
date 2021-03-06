/***********************************************************
 * @Description : 
 * @author      : 梁山广(Laing Shan Guang)
 * @date        : 2018/4/7 下午5:02
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package chapter3com;

public class P161Producer {
    private String lock;

    public P161Producer(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (!P159ValueObject.value.equals("")) {
                    System.out.println( Thread.currentThread().getName() + " WAITING 了 ！♡");
                    lock.wait();
                }
                System.out.println( Thread.currentThread().getName() + " RUNNABLE 了！");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                // System.out.println("set的值是：" + value) ;
                P159ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
