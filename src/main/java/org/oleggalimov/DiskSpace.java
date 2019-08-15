package org.oleggalimov;

import java.util.*;

public class DiskSpace {

    public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
        //the main concept is create an array of 1/0 values, which is like to "file system"
        // then we a looking for free uninterrupted space of fileSize between occupied sectors
        int [] occSectors =  new int [blockSize+1];
        int freeSpace = 0;
        for (Integer currentSec : occupiedSectors) {
            if (currentSec<occSectors.length && currentSec>0 ) {
                occSectors[(currentSec)] = 1;
            }
        }
        for (int i = 1; i <= blockSize; i++) {
            freeSpace = (occSectors[i] == 0) ? (freeSpace + 1) : 0;
            if (freeSpace == fileSize) {
                return true;
            }
        }
        return false;
    }
}