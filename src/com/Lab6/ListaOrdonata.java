package com.Lab6;

import java.util.Arrays;

public class ListaOrdonata implements Lista {
    private Integer list[];
    private int length;

    public ListaOrdonata(int[] list) {
        this.length = list.length;
        this.list = new Integer[list.length];
        for (int i = 0; i < list.length; i++)
            this.list[i] = list[i];
        Arrays.sort(list);
    }

    @Override
    public void addElement(Integer integer) {
        length++;
        Integer copy[] = this.list.clone();
        this.list = new Integer[length];
        for (int i = 0; i < length - 1; i++) {
            this.list[i] = copy[i];
        }
        this.list[length-1] = integer;
        Arrays.sort(list);
    }

    @Override
    public boolean removeElement(Integer integer) {
        for (int i= 0; i < length; i++) {
            if (list[i].equals(integer)) {
                Integer copy[] = this.list.clone();
                this.list = new Integer[length - 1];
                int index = 0;
                for (int j = 0; j < length; j++) {
                    if (j != i)
                        list[index++] = copy[j];
                }
                length--;
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(Integer integer) {
        int count = 0;
        while(true) {
            if(removeElement(integer)) {
                count++;
            }
            else break;
        }
        return count;
    }

    @Override
    public Integer get(int index) {
        return this.list[index];
    }

    @Override
    public int length() {
        return length;
    }


    public static void main(String[] args) {
        int vector[] = {1,23,5,4};
        ListaOrdonata ord = new ListaOrdonata(vector);
        ord.addElement(10);
        ord.addElement(1);
        ord.addElement(8);
        System.out.println(ord.removeElement(5));
        System.out.println(ord.removeAll(1));
        for (int i = 0; i < ord.length; i++)
            System.out.println(ord.get(i));
    }
}
