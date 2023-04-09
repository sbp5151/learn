package com.example.thread

import android.util.Log
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicInteger

object ThreadPoolUtil {

    private const val TAG = "ThreadPoolUtil"
    private const val DEFAULT_CORE_POOL_SIZE = 10
    private const val DEFAULT_MAX_POOL_SIZE = 10
    private const val DEFAULT_KEEP_ALIVE_TIME = 60L
    private const val DEFAULT_QUEUE_SIZE = 10

    //1、自定义线程池
    private val mDefaultThreadPool: ThreadPoolExecutor by lazy {
        ThreadPoolExecutor(
            DEFAULT_CORE_POOL_SIZE,//核心线程数量，核心线程正常不会消亡，有任务过来直接创建
            DEFAULT_MAX_POOL_SIZE,//最大线程数量，当核心线程都在执行，任务过来会先存到队列，如果队列已满，会创建非核心线程，如果当前线程大于等于最大线程，直接抛异常（rejectedException）
            DEFAULT_KEEP_ALIVE_TIME,//非核心线程空闲时长，当设置allowCoreThreadTimeOut=true,核心线程也受控制
            TimeUnit.SECONDS,//时间单位
            LinkedBlockingQueue(DEFAULT_QUEUE_SIZE),//任务队列，当池中线程数量大于等于核心线程池数量，任务插入队列等待
            DefaultThreadFactory(),//线程工厂
            DefaultRejectedExecutionHandler()//当前线程大于等于最大线程，且任务队列也满了，会抛异常
        )
    }

    //2、固定线程池数量，且都是核心线程池，任务队列int最大值
    public val mFixedThreadPool: ExecutorService = Executors.newFixedThreadPool(10)

    //3、无限线程数量，且都为非核心线程池，任务队列无法插入任务，所以所有任务都可以立即执行
    public val mCachedThreadPool: ExecutorService = Executors.newCachedThreadPool()

    //4、有固定核心线程、无限非核心线程，任务队列默认容量16
    public val mScheduledThreadPool: ExecutorService = Executors.newScheduledThreadPool(10)

    //5、只有一个固定线程，保证所有任务都会在一个线程当中调用，这使得任务之间不需要处理线程同步问题
    public val mSingleThreadPool: ExecutorService = Executors.newSingleThreadExecutor()

    fun execute(run: Runnable) {
        mDefaultThreadPool.execute(run)
    }

    fun submit(run: Runnable): Future<*>? {
        return mDefaultThreadPool.submit(run)
    }

    fun submit(call: Callable<*>): Future<*> {
        return mDefaultThreadPool.submit(call)
    }
    // TODO: 2022/3/17 futureTask使用

    private class DefaultThreadFactory : ThreadFactory {
        var threadNum = AtomicInteger(1)
        override fun newThread(r: Runnable?): Thread {
            val threadName = "myThread :#${threadNum.addAndGet(1)}"
            Log.d(TAG, "newThread $threadName")
            return Thread(r, threadName)
        }
    }

    private class DefaultRejectedExecutionHandler : RejectedExecutionHandler {
        override fun rejectedExecution(r: Runnable?, executor: ThreadPoolExecutor?) {
            Log.d(TAG, "rejectedExecution runnable $r executor：$executor")
        }
    }
}