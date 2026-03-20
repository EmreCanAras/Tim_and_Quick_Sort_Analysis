# Tim_and_Quick_Sort_Analysis
Performance analysis and comparison of Tim Sort and Quick Sort (First, Last, Middle, Random, and Median pivot) algorithms using Java.

# Comparison of Tim Sort and Quick Sort

Performance analysis and comparison of Tim Sort and Quick Sort (First, Last, Middle, Random, and Median pivot) algorithms using Java.

Developed as part of **CME 2204 Algorithm Analysis** — Dokuz Eylül University, Computer Engineering Department.

---

## Overview

This project implements and benchmarks two sorting algorithms across four different input configurations of **1,000,000 integers**:

- **Tim Sort** — a hybrid, stable sorting algorithm combining Merge Sort and Insertion Sort
- **Quick Sort** — a divide-and-conquer algorithm tested with five pivot selection strategies: First, Last, Middle, Random, and Median element

---

## Project Structure

```
├── src/
│   ├── Main.java
│   ├── SortAlgorithm.java
│   ├── TimSort.java
│   ├── QuickSort.java
│   ├── Sorter.java
│   └── FileOperations.java
├── random.txt
├── semi_ordered.txt
└── project_report.pdf
```

---

## Input & Output

Place `random.txt` and `semi_ordered.txt` in the project root directory before running.

The program generates **24 output files** following the naming convention:

```
(algorithm)_(data_type)_out.txt
```

Examples: `timsort_random_out.txt`, `quicksort_middle_increasing_out.txt`

---

## Results Summary

| Algorithm | Random | Semi-Ordered | Increasing | Decreasing |
|---|---|---|---|---|
| Tim Sort | 93 ms | 48 ms | 17 ms | 39 ms |
| QS — First | 91023 ms | 91363 ms | 90644 ms | 91043 ms |
| QS — Last | 164009 ms | 207259 ms | 257865 ms | 258489 ms |
| QS — Middle | 17 ms | 15 ms | 11 ms | 11 ms |
| QS — Random | 69 ms | 37 ms | 36 ms | 36 ms |
| QS — Median | 2708 ms | 5861 ms | 12 ms | 12 ms |

> For a detailed analysis and discussion of these results, see [**project_report.pdf**](./project_report.pdf).

---

## Hardware

- **Device:** Apple MacBook Air (M1)
- **RAM:** 8 GB Unified Memory
- **OS:** macOS 26.3.1
- **JDK:** 25
- **IDE:** IntelliJ IDEA

---

## Key Implementation Details

- Stack overflow prevention via **tail call optimization** in Quick Sort
- **Sentinel value** (`Integer.MAX_VALUE`) used in Tim Sort merge to eliminate boundary checks
- **Run size of 64** selected to keep the number of runs close to a power of two
- Bottom-up iterative merge strategy — no recursion overhead

---

*Dokuz Eylül University — CME 2204 Algorithm Analysis — Spring 2025-2026*
