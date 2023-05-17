import java.util.TreeMap;

public class HeapSort {
    TreeMap<Integer, Integer> heapSort(TreeMap<Integer, Integer> numbers) {

        int root;
        int left;
        int right;
        int iStart = 0;
        int end = 0;
        int chek = 0;
        if (chek != numbers.size() % 2) {
            chek = 1;
        } else {
            chek = 2;
        }
        while (end != (numbers.size() / 2 - chek) + 1) {

            iStart = 0;
            while (iStart != (numbers.size() / 2 - chek) + 1) {

                if (numbers.get(iStart) <= numbers.get(iStart * 2 + 1)) {
                    left = numbers.get(iStart);
                    root = numbers.get(iStart * 2 + 1);
                    numbers.replace(iStart, root);
                    numbers.replace(iStart * 2 + 1, left);
                }
                if (numbers.get(iStart) <= numbers.get(iStart * 2 + 2)) {

                    right = numbers.get(iStart);
                    root = numbers.get(iStart * 2 + 2);
                    numbers.replace(iStart, root);
                    numbers.replace(iStart * 2 + 2, right);

                }
                if (numbers.get(iStart * 2 + 1) <= numbers.get(iStart * 2 + 2)) {

                    left = numbers.get(iStart * 2 + 2);
                    right = numbers.get(iStart * 2 + 1);
                    numbers.replace(iStart * 2 + 1, left);
                    numbers.replace(iStart * 2 + 2, right);

                }
                iStart += 1;

            }
            if (chek == 1) {
                iStart = (numbers.size() / 2 - chek);
            } else {
                iStart = (numbers.size() / 2 - chek) + 1;
            }
            while (iStart >= 0) {

                if (numbers.get(iStart) <= numbers.get(iStart * 2 + 1)) {
                    left = numbers.get(iStart);
                    root = numbers.get(iStart * 2 + 1);
                    numbers.replace(iStart, root);
                    numbers.replace(iStart * 2 + 1, left);
                    
                }
                if (iStart != (numbers.size() / 2 - chek) + 1) {
                    if (numbers.get(iStart) <= numbers.get(iStart * 2 + 2)) {

                        right = numbers.get(iStart);
                        root = numbers.get(iStart * 2 + 2);
                        numbers.replace(iStart, root);
                        numbers.replace(iStart * 2 + 2, right);
                        

                    }
                    if (numbers.get(iStart * 2 + 1) < numbers.get(iStart * 2 + 2)) {

                        left = numbers.get(iStart * 2 + 2);
                        right = numbers.get(iStart * 2 + 1);
                        numbers.replace(iStart * 2 + 1, left);
                        numbers.replace(iStart * 2 + 2, right);
                        

                    }
                }

                iStart -= 1;

            }
            
            end++;
        }

        return numbers;

    }
}
