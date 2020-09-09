package com.xsx.demo.tools;

/**
 * TODO
 *
 * @author xsx
 * @date 2020/9/8 0008 12:33
 */
public class SnowFlakeUtil {
    private final long id;
    private final long epoch = 1524291141010L;
    private final long workerIdBits = 10L;
    private final long maxWorkerId;
    private long sequence;
    private final long sequenceBits;
    private final long workerIdShift;
    private final long timestampLeftShift;
    private final long sequenceMask;
    private long lastTimestamp;
    private static SnowFlakeUtil flowIdWorker = new SnowFlakeUtil(1L);

    private SnowFlakeUtil(long id) {
        this.getClass();
        this.maxWorkerId = ~(-1L << 10);
        this.sequence = 0L;
        this.sequenceBits = 12L;
        this.getClass();
        this.workerIdShift = 12L;
        this.getClass();
        this.getClass();
        this.timestampLeftShift = 12L + 10L;
        this.getClass();
        this.sequenceMask = ~(-1L << 12);
        this.lastTimestamp = -1L;
        if (id <= this.maxWorkerId && id >= 0L) {
            this.id = id;
        } else {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", this.maxWorkerId));
        }
    }

    public synchronized long nextId() {
        long timestamp = timeGen();
        if (this.lastTimestamp == timestamp) {
            this.sequence = this.sequence + 1L & this.sequenceMask;
            if (this.sequence == 0L) {
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0L;
        }

        if (timestamp < this.lastTimestamp) {
            System.out.println(String.format("clock moved backwards.Refusing to generate id for %d milliseconds", this.lastTimestamp - timestamp));
            return -1L;
        } else {
            this.lastTimestamp = timestamp;
            this.getClass();
            return timestamp - 1524291141010L << (int)this.timestampLeftShift | this.id << (int)this.workerIdShift | this.sequence;
        }
    }

    public static SnowFlakeUtil getFlowIdInstance() {
        return flowIdWorker;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp;
        for(timestamp = timeGen(); timestamp <= lastTimestamp; timestamp = timeGen()) {
        }

        return timestamp;
    }

    private static long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        for(int i = 0; i < 263; ++i) {
            SnowFlakeUtil snowFlakeUtil = getFlowIdInstance();
            System.out.println(snowFlakeUtil.nextId());
        }

    }
}
