package com.skyscrapper;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

    public class Service {

        int floors;
        int floorSize[];
        Scanner sc = new Scanner(System.in);

    public void getInformation() {

        System.out.println("Enter the total no of floors in the building");
        floors = sc.nextInt();
        floorSize = new int[floors];
        int size;

        for(int i =0; i< floors ; i++) {
            System.out.println("Enter the floor size given on day " + ++i);
            i--;

            size = sc.nextInt();
            if(size > floors) {
                System.out.println("Floor size is greater than floor count. Floors :" + this.floors + "try again...");
                i--;
                continue;
            }

            for(int j = 0 ; j < i; j++) {
                if(floorSize[j] == size) {
                    System.out.println("Duplication not allowed.");
                    i--;
                    break;
                }
            }
            floorSize[i] = size;
        }

        for(int i =0 ; i<this.floors;i++) {
            System.out.println("Floor sizes :");
            System.out.println(floorSize[i]);
        }
        System.out.println();
    }

    public void assembleFloors() {

        PriorityQueue <Integer> pq = new PriorityQueue(Collections.reverseOrder());

        int day;
        int lastDay = this.floors;
        int flr = this.floors;

        System.out.println("The order of construction is as follows");

        for(int i = 0; i < this.floors ; i++) {
            day = i+1;
            System.out.println("Day " + day);

            if(flr != this.floorSize[i] ) {
                System.out.println();
                pq.add(this.floorSize[i]);
            }
            else {
                System.out.print(this.floorSize[i]);
                int a = this.floorSize[i];
                a--;
                if(!pq.isEmpty()  )
                {
                    if(pq.peek() == a)
                    {
                        while(!pq.isEmpty())
                        {
                            System.out.print(" "+ pq.peek());
                            pq.poll();
                            flr--;
                        }
                    }
                }
                flr--;
            }
            System.out.println();
        }
    }
}