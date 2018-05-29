/*
 * Copyright 2018, Oath Inc
 * Licensed under the terms of the Apache License 2.0. Please refer to accompanying LICENSE file for terms.
 */

package com.oath.halodb;

import com.google.common.base.MoreObjects;

/**
 * @author Arjun Mannaly
 */
public class HaloDBOptions implements Cloneable {

    // threshold of stale data at which file needs to be compacted.
    private double compactionThresholdPerFile = 0.75;

    private long maxFileSize = 1024 * 1024; /* 1mb file recordSize */

     // Data will be flushed to disk after flushDataSizeBytes have been written.
     // -1 disables explicit flushing and let the kernel handle it.
    private long flushDataSizeBytes = -1;

    // used for testing.
    private boolean isCompactionDisabled = false;

    private int numberOfRecords = 1_000_000;

    // MB of data to be compacted per second.
    private int compactionJobRate = 1024 * 1024 * 1024;

    private boolean cleanUpKeyCacheOnClose = false;

    // Just to avoid clients having to deal with CloneNotSupportedException
    public HaloDBOptions clone() {
        try {
            return (HaloDBOptions) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("compactionThresholdPerFile", compactionThresholdPerFile)
            .add("maxFileSize", maxFileSize)
            .add("flushDataSizeBytes", flushDataSizeBytes)
            .add("isCompactionDisabled", isCompactionDisabled)
            .add("numberOfRecords", numberOfRecords)
            .add("compactionJobRate", compactionJobRate)
            .add("cleanUpKeyCacheOnClose", cleanUpKeyCacheOnClose)
            .toString();
    }

    public void setCompactionThresholdPerFile(double compactionThresholdPerFile) {
        this.compactionThresholdPerFile = compactionThresholdPerFile;
    }

    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public void setFlushDataSizeBytes(long flushDataSizeBytes) {
        this.flushDataSizeBytes = flushDataSizeBytes;
    }

    public void setCompactionDisabled(boolean compactionDisabled) {
        isCompactionDisabled = compactionDisabled;
    }

    public void setNumberOfRecords(int numberOfRecords) {
        this.numberOfRecords = numberOfRecords;
    }

    public void setCompactionJobRate(int compactionJobRate) {
        this.compactionJobRate = compactionJobRate;
    }

    public void setCleanUpKeyCacheOnClose(boolean cleanUpKeyCacheOnClose) {
        this.cleanUpKeyCacheOnClose = cleanUpKeyCacheOnClose;
    }

    public double getCompactionThresholdPerFile() {
        return compactionThresholdPerFile;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }


    public long getFlushDataSizeBytes() {
        return flushDataSizeBytes;
    }

    public boolean isCompactionDisabled() {
        return isCompactionDisabled;
    }

    public int getNumberOfRecords() {
        return numberOfRecords;
    }

    public int getCompactionJobRate() {
        return compactionJobRate;
    }

    public boolean isCleanUpKeyCacheOnClose() {
        return cleanUpKeyCacheOnClose;
    }
}