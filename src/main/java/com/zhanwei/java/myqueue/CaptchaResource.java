//package com.zhanwei.java.myqueue;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class CaptchaResource<T> implements ICaptchaResource<T> {
//	private static Logger picpoolLogger = LoggerFactory.getLogger("poollogger");
//
//	protected final static int maxLength;
//    protected AtomicInteger refreshBigCount;
//    protected AtomicInteger customBigCount;
//    protected Object[] big;
//
//    public CaptchaResource() {
//    	this.big = new Object[maxLength];
//    	refreshBigCount = new AtomicInteger(0);
//    	customBigCount = new AtomicInteger(0);
//    }
//
//    static {
//        int capacity = 1;
//        try {
//			while (capacity < Configuration.getInstance().getInt("PIC_POOL_CAPACITY")) {
//			    capacity <<= 1;
//			}
//		} catch (ConfigurationException e) {
//			picpoolLogger.info("Configuration load data error ...");
//			e.printStackTrace();
//		}
//        maxLength = capacity;
//        picpoolLogger.info("CAPACITY : " + maxLength);
//    }
//
//
//    @SuppressWarnings("unchecked")
//	@Override
//    public T get() {
//        int tmp = customBigCount.getAndIncrement();
//        int t = tmp&(maxLength-1);
//        if (big[t] == null) {
//            customBigCount.set(0);
//            t = 0;
//        }
//        return (T)big[t];
//    }
//
//
//	@Override
//    public void set(T image) {
//        int tmp = refreshBigCount.getAndIncrement();
//        int t = tmp&(maxLength-1);
//        big[t] = image;
//    }
//
//
//}