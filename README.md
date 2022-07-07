# FracCalc
Created by Aakash Pathak

## Introduction
The objective of this program is to create a calculator to compute arithmetic
operations between integers and/or fractions and output the result as a reduced mixed
fraction.

Image: 

![FracCalc Image](https://github.com/AakashPathak1/FracCalc/blob/main/FracCalc.png)


### Examples
| Input             | Output    | Notes                                         |
|-------------------|-----------|-----------------------------------------------|
| `1/4 + 1_1/2`     | `1_3/4`   |                                               |
| `8/4 + 2`         | `4`       | Input may be an improper fraction.            |
| `-1 * -1/2`       | `1/2`     |                                               |
| `-11/17 + -1/17`  | `-12/17`  |                                               |
| `0 * 25_462/543`  | `0`       | Remember to check for border/special cases.   |

| Input                     | Output    |
|---------------------------|-----------|
| `1 + 3 + 3`               | `6`       |
| `3/4 * 4`                 | `3`       |
| `-1/2 * 4 + 3/4`          | `-1_1/4`  |
| `5_3/4 - -6_8/8 - 5_3/4`  | `7`       |

| Input     | Output                                    |
|-----------|-------------------------------------------|
| `1/0 + 1` | `ERROR: Cannot divide by zero.`           |
| `1 ++ 2`  | `ERROR: Input is in an invalid format.`   |

