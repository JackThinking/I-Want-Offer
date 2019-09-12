package chap2;

/**
 * Created by Citrix on 2018-12-23.
 */
public class Question_2 {

    /*
     * 单例模式1：懒汉式，线程不安全
     * */
    public static class Singleton {
        /*
         * 不要final的，要不然instance没法改
         * */
        private static Singleton instannce;

        /*
         * 构造器得是私有的，只有自己的类才能调用
         * */
        private Singleton() {
        }

        public static Singleton getInstannce() {
            if (instannce == null) {
                instannce = new Singleton();
            }
            return instannce;
        }
    }

    /*
     * 单例模式2：饿汉式，线程安全
     * */
    public static class Singleton2 {
        /*
         * JVM保证static域的线程安全,这边加final好像不加也行
         * */
        private final static Singleton2 uniqueInstance = new Singleton2();

        private Singleton2() {

        }

        public static Singleton2 getInstance() {
            return uniqueInstance;
        }
    }

    /*
     * 单例模式3：饿汉式，线程安全，但是效率低下（因为只有在第一次创建的时候才需要同步）
     * */
    public static class Singleton3 {
        private static Singleton3 uniqueInstance;

        private Singleton3() {
        }

        public static synchronized Singleton3 getInstance() {
            if (uniqueInstance == null) {
                uniqueInstance = new Singleton3();
            }
            return uniqueInstance;
        }
    }

    /*
     * 单例模式4：双重检查加锁，线程安全（推荐），但是有点难度
     * */
    public static class Singleton4 {
        /*
         * 加上volatile提供可见性
         * */
        private volatile static Singleton4 uniqueInstance;

        private Singleton4() {
        }

        public static Singleton4 getInstance() {
            /*
             * synchronized块只在第一次初始化的时候同步
             * */
            synchronized (Singleton4.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton4();
                }
            }
            return uniqueInstance;
        }
    }

    /*
     * 单例模式4：饿汉式，静态内部类，线程安全(放在静态内部类里，我感觉和放在外面生成也差不多）
     * */
    public static class Singleton5 {
        // 静态内部类，初始化执行，且直接生成单例
        private static class InnerHolder {
            private static Singleton5 uniqueInstance = new Singleton5();
        }
        // 构造函数
        private Singleton5() {
        }
        // 获取静态内部类的属性
        public static Singleton5 getInstance() {
            return InnerHolder.uniqueInstance;
        }
    }
}
