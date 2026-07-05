# Dutch National Flag Algorithm

## Overview

The **Dutch National Flag algorithm** (also called the **Sort Colors** problem) is a technique to sort an array containing only three distinct values — typically represented as `0`, `1`, and `2` — in a single pass, using constant extra space.

The name comes from Edsger Dijkstra, who proposed the problem: given balls of three colors (red, white, blue) arranged randomly, group them so the array looks like the Dutch flag — one color, then the next, then the last, with no mixing.

In programming terms: sort an array of `0`s, `1`s, and `2`s so that all `0`s come first, then all `1`s, then all `2`s.

---

## Why It's Useful

- Sorts in **O(n)** time with a **single pass** through the array.
- Uses **O(1)** extra space (in-place, no auxiliary array).
- A classic example of the **three-pointer technique**, useful in many partitioning problems (e.g., quicksort's partition step, partitioning around a pivot).

---

## The Idea

We maintain **three pointers**:

| Pointer   | Meaning                                                              |
|-----------|-----------------------------------------------------------------------|
| `start`   | Boundary — everything before this index is a confirmed `0`           |
| `end`     | Boundary — everything after this index is a confirmed `2`            |
| `current` | The index currently being examined                                   |

The array is conceptually divided into four regions at any point:

```
[ 0 0 0 | 1 1 1 | unknown... | 2 2 2 ]
          ^               ^
        start           end
              ^
           current
```

We scan with `current` from left to right, and decide what to do based on the value found:

1. **If `colors[current] == 0`**
   Swap it with `colors[start]`, then move both `start` and `current` forward.
   *(The element at `start` is now guaranteed to belong in the "1" region or later, so it's safe to advance `current` too.)*

2. **If `colors[current] == 1`**
   It's already in the right place — just move `current` forward.

3. **If `colors[current] == 2`**
   Swap it with `colors[end]`, then move `end` backward.
   *(Do **not** advance `current` here — the value swapped in from `end` hasn't been checked yet, so it needs to be examined next.)*

The process continues until `current` passes `end`.

---

## Java Implementation

```java
import java.util.Arrays;

public class SortColors {

    public static int[] sort(int[] colors) {
        int start = 0, end = colors.length - 1, current = 0;

        while (current <= end) {
            if (colors[current] == 0) {
                int temp = colors[current];
                colors[current] = colors[start];
                colors[start] = temp;
                start++;
                current++;
            } else if (colors[current] == 1) {
                current++;
            } else {
                int temp = colors[current];
                colors[current] = colors[end];
                colors[end] = temp;
                end--;
                // current is NOT incremented here
            }
        }
        return colors;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + Arrays.toString(inputs[i]));
            int[] sortedColors = SortColors.sort(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + Arrays.toString(sortedColors));
            System.out.println("-".repeat(100));
        }
    }
}
```

---

## Walkthrough Example

Input: `[2, 1, 1, 0, 1, 0, 2]`

| Step | Array State                  | start | current | end | Action                          |
|------|-------------------------------|-------|---------|-----|----------------------------------|
| 0    | [2, 1, 1, 0, 1, 0, 2]         | 0     | 0       | 6   | colors[0]=2 → swap with end      |
| 1    | [2, 1, 1, 0, 1, 0, 2]         | 0     | 0       | 5   | colors[0]=2 → swap with end      |
| 2    | [0, 1, 1, 0, 1, 2, 2]         | 0     | 0       | 4   | colors[0]=0 → swap with start    |
| 3    | [0, 1, 1, 0, 1, 2, 2]         | 1     | 1       | 4   | colors[1]=1 → move on            |
| 4    | [0, 1, 1, 0, 1, 2, 2]         | 1     | 2       | 4   | colors[2]=1 → move on            |
| 5    | [0, 1, 1, 0, 1, 2, 2]         | 1     | 3       | 4   | colors[3]=0 → swap with start    |
| 6    | [0, 0, 1, 1, 1, 2, 2]         | 2     | 4       | 4   | colors[4]=1 → move on            |
| 7    | [0, 0, 1, 1, 1, 2, 2]         | 2     | 5       | 4   | current > end → stop             |

**Result:** `[0, 0, 1, 1, 1, 2, 2]` ✅

---

## Common Bugs to Watch For

1. **Loop condition**: Use `current <= end`, not `current < end`. Otherwise, the last unexamined element in the window is skipped.
2. **Incrementing `current` after a swap with `end`**: This is the most common mistake. The value swapped in from `end` is unverified — it might be another `0`, `1`, or `2` — so it must be re-checked, not skipped.
3. **Direction of `end`**: `end` should move **left** (`end--`), since the confirmed "2" region grows from the right side inward.

---

## Complexity

| Metric           | Value  |
|-------------------|--------|
| Time Complexity   | O(n)   |
| Space Complexity  | O(1)   |
| Passes over array | 1      |

---

## Related Problems

- **Partition step in Quicksort** (Lomuto / Hoare partition schemes)
- **LeetCode 75: Sort Colors**
- General **three-way partitioning** around a pivot value