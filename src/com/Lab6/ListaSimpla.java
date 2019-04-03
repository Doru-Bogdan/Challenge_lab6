package com.Lab6;

public class ListaSimpla implements Lista {
    private Integer list[];
    private int length;

    public ListaSimpla(int[] list) {
        this.length = list.length;
        this.list = new Integer[list.length];
        for (int i = 0; i < list.length; i++)
            this.list[i] = list[i];
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
        ListaSimpla list = new ListaSimpla(vector);
        list.addElement(7);
        list.addElement(7);
        list.addElement(7);
        System.out.println(list.removeElement(23));
        System.out.println(list.removeAll(7));
        for (int i = 0; i < list.length; i++)
            System.out.println(list.get(i));


    }
}
