package com.Lab6;

public interface Lista {
    void addElement(Integer integer);//adauga elementul integer in vector
    boolean removeElement(Integer integer);//sterge elementul integer din vector si returneaza true/false in cazul in care a fost sters / nu a fost sters
    int removeAll(Integer integer);//returneaza de cate ori s-a sters elementul integer din lista si sterge toate aparitiile lui in vector
    Integer get(int index);//returneaza elementul din vector la pozitia index
    int length();//returneaza lungimea listei
}
