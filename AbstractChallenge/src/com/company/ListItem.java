package com.company;

import java.util.List;

public abstract class ListItem {
    private String previous;
    private String next;
    private List<String> list;
    private int currentPosition;

    public ListItem(List<String> list) {
        this.previous = null;
        this.next = list.get(0);
        this.list = list;
        this.currentPosition = 0;
    }

    public String getPrevious() {
        String returnValue = this.previous;
        moveToPrevious();
        return returnValue;
    }

    public String getNext() {
        String returnValue = this.next;
        moveToNext();
        return returnValue;
    }

    public boolean moveToPrevious() {
        if (currentPosition <= 0) {
            this.previous = null;
            this.next = this.list.get(0);
            return false;
        }
        this.previous = this.list.get(currentPosition - 1);
        this.next = this.list.get(currentPosition);
        currentPosition--;
        return true;
    }

    public boolean moveToNext() {
        int last = this.list.size() - 1;
        if (currentPosition >= last) {
            this.previous = this.list.get(last);
            this.next = null;
            return false;
        }
        this.previous = this.list.get(currentPosition);
        this.next = this.list.get(currentPosition + 1);
        currentPosition++;
        return true;
    }

    public void setNext(String nextValue) {
        int index = this.list.indexOf(nextValue);
        if (index >= 0) {
            this.currentPosition = index;
            moveToPrevious();
        } else {
            System.out.println(nextValue + " not on the list.");
        }
    }

    public void setPrevious(String previousValue) {
        int index = this.list.indexOf(previousValue);
        if (index >= 0) {
            this.currentPosition = index;
            moveToNext();
        } else {
            System.out.println(previousValue + " not on the list.");
        }
    }


}
