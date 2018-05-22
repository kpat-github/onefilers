package kp.onefilers.geeksforgeeks.ds.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap<ITEM extends Object> {

    private List<ITEM> items = null;
    private int count = 0;

    public static void main(String[] args) {
        MaxHeap<Integer> mh = new MaxHeap<>(3);

        mh.addItem(1000000);

        mh.addItem(800000);
        mh.addItem(700000);

        mh.addItem(600000);
        mh.addItem(630000);
        mh.addItem(550000);
        mh.addItem(530000);

//        mh.addItem(51);
//        mh.addItem(48);
//        mh.addItem(46);
//        mh.addItem(41);
//        mh.addItem(37);
//        mh.addItem(33);
//        mh.addItem(31);
//        mh.addItem(28);

//        mh.addItem(27);
//        mh.addItem(26);
//        mh.addItem(25);
//        mh.addItem(24);
//        mh.addItem(23);
//        mh.addItem(22);
//        mh.addItem(21);
//        mh.addItem(20);
//        mh.addItem(19);
//        mh.addItem(18);
//        mh.addItem(17);
//        mh.addItem(16);
//        mh.addItem(15);
//        mh.addItem(14);
//        mh.addItem(13);
//        mh.addItem(12);
//
//        mh.addItem(27);
//        mh.addItem(26);
//        mh.addItem(25);
//        mh.addItem(24);
//        mh.addItem(23);
//        mh.addItem(22);
//        mh.addItem(21);
//        mh.addItem(20);
//        mh.addItem(19);
//        mh.addItem(18);
//        mh.addItem(17);
//        mh.addItem(16);
//        mh.addItem(15);
//        mh.addItem(14);
//        mh.addItem(13);
//        mh.addItem(12);
//        mh.addItem(27);
//        mh.addItem(26);
//        mh.addItem(25);
//        mh.addItem(24);
//        mh.addItem(23);
//        mh.addItem(22);
//        mh.addItem(21);
//        mh.addItem(20);
//        mh.addItem(19);
//        mh.addItem(18);
//        mh.addItem(17);
//        mh.addItem(16);
//        mh.addItem(15);
//        mh.addItem(14);
//        mh.addItem(13);
//        mh.addItem(12);

        mh.print();
    }

    public MaxHeap(int size) {
        items = new ArrayList<ITEM>(size);
    }

    public void addItem(ITEM item) {
        this.items.add(item);
        this.count++;
    }

    public void print() {
        List<String> prn = new ArrayList<String>();
        prn.add("");
        String tab = "\t";
        int depth = 0, icnt = 0, rcnt = 1;

        for (int i = 0; i < count; i++) {
            prn.add(depth, prn.remove(depth).concat(String.format("%s%s%s", tab, items.get(i).toString(), tab)));
            icnt++;
            if (rcnt == icnt) {
                rcnt = Double.valueOf(Math.pow(2, ++depth)).intValue();
                for (int j=0; j < depth; j++) {
                    prn.add(j, prn.remove(j).replaceAll(tab,tab+tab));
                }
                icnt = 0;
                prn.add("");
            }
        }
        for (String str : prn) {
            System.out.println(str+"\n");
        }
    }
}
