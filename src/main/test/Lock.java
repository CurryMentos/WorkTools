//import java.util.Collections;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by zengyouzu on 2019/8/5.
// */
//public class Lock {
//    public boolean tryLock(RedisLock redisLock) {
//        int i = 0;
//        while (i < 3) {
//            if (stringRedisTemplate.opsForValue().setIfAbsent(redisLock.getLockKey(), redisLock.getLockValue(), 30, TimeUnit.SECONDS)) {
////                System.out.println(Thread.currentThread().getId() + "加锁成功! key:"+redisLock.getLockKey()+"value:"+redisLock.getLockValue());
//                //开启定时刷新过期时间
//                redisLock.isOpenExpirationRenewal = true;
//                redisLock.scheduleExpirationRenewal(stringRedisTemplate);
//                return true;
//            }
//            i++;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
////        System.out.println(Thread.currentThread().getId() + "加锁失败!");
//        return false;
//    }
//
//    public RedisLock(String lockKey) {
//        this.lockKey = lockKey;
//        this.lockValue = UUID.randomUUID().toString();
//    }
//
//    private String lockKey;
//    private String lockValue;
//    protected volatile boolean isOpenExpirationRenewal = true;
//
//    private StringRedisTemplate stringRedisTemplate;
//
//    public String getLockKey() {
//        return lockKey;
//    }
//
//
//    public String getLockValue() {
//        return lockValue;
//    }
//
//    public void setLockValue(String lockValue) {
//        this.lockValue = lockValue;
//    }
//
//    /**
//     * 开启定时刷新
//     */
//    protected void scheduleExpirationRenewal(StringRedisTemplate stringRedisTemplate) {
//        this.stringRedisTemplate = stringRedisTemplate;
//        Thread renewalThread = new Thread(new ExpirationRenewal());
//        renewalThread.start();
//    }
//
//
//    public void sleepBySencond(int sencond) {
//        try {
//            Thread.sleep(sencond * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 刷新key的过期时间
//     */
//    private class ExpirationRenewal implements Runnable {
//        @Override
//        public void run() {
//            while (isOpenExpirationRenewal) {
//                //休眠10秒
//                System.out.println("执行延迟失效时间中..."+Thread.currentThread().getId());
//                stringRedisTemplate.opsForValue().setIfAbsent(lockKey, lockValue, 30, TimeUnit.SECONDS);
//                sleepBySencond(10);
//            }
//        }
//    }
//
//    //释放锁
//    public boolean releaseLock(RedisLock redisLock) {
////     错误示范哦   stringRedisTemplate.delete(redisLock.getLockKey());
////        redisLock.isOpenExpirationRenewal = false;
//        redisLock.isOpenExpirationRenewal = false;
//        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
//        redisScript.setScriptText(RELEASE_LOCK_LUA_SCRIPT);
//        redisScript.setResultType(Long.class);
//
//        Long result=stringRedisTemplate.execute(redisScript, Collections.singletonList(redisLock.getLockKey()), redisLock.getLockValue());
//        if(result==RELEASE_LOCK_SUCCESS_RESULT) {
////            System.out.println("解锁成功：key:"+redisLock.getLockKey()+"value:"+redisLock.getLockValue());
//            return true;
//        }
////        System.out.println("失败解锁结果：key:"+redisLock.getLockKey()+"value:"+redisLock.getLockValue());
////        System.out.println("失败解锁锁值："+stringRedisTemplate.opsForValue().get(redisLock.getLockKey()));
//        return false;
//    }
//}
